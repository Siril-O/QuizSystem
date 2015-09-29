package ua.edu.rd.web.controller;

import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.QuizResult;
import ua.edu.rd.domain.Role;
import ua.edu.rd.domain.User;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

	@RequestMapping("/")
	public String showStudents(
			@RequestParam(value = "succesMessage", required = false) String message,
			Model model) {
		List<User> users = userService.getAllUsersByRole(Role.ROLE_STUDENT);
		model.addAttribute("users", users);
		model.addAttribute("succesMessage", message);
		return "admin/user";
	}

	@RequestMapping("/all")
	public String showUsers(
			@RequestParam(value = "succesMessage", required = false) String message,
			Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("succesMessage", message);
		return "superadmin/users";
	}

	@RequestMapping("/edit")
	public String viewEditForm(Model model, @RequestParam("userId") User user,
			@ModelAttribute("user") User signedInUser) {
		return viewUserEditForm(user, model, signedInUser);
	}

	private String viewUserEditForm(User user, Model model, User signedInUser) {
		model.addAttribute("userToEdit", user);
		if (signedInUser.getRole() == Role.ROLE_ADMIN) {
			return "admin/editUser";
		} else {
			return "superadmin/editUser";
		}
	}

	@RequestMapping("/update")
	public String updateUser(@RequestParam("id") User oldUser,
			@Valid @ModelAttribute("userToEdit") User userToEdit,
			BindingResult bindResult, Model model,
			RedirectAttributes reditectAttributes) {
		userToEdit.setPassword(oldUser.getPassword());
		userToEdit.setRole(oldUser.getRole());
		User signedInUser = addUser(model);
		if (bindResult.hasFieldErrors("name")
				|| bindResult.hasFieldErrors("surname")
				|| bindResult.hasFieldErrors("email")) {
			return viewUserEditForm(userToEdit, model, signedInUser);
		}
		userService.update(userToEdit);
		reditectAttributes.addAttribute("succesMessage", "UserEdited");
		return "redirect:"
				+ ((signedInUser.getRole() == Role.ROLE_ADMIN) ? "all" : "");
	}

	@RequestMapping("/assignQuizForm")
	public String viewQuizAssignForm(@RequestParam("userId") User user,
			Model model) {
		List<Quiz> quizList = quizService.findAllQuizes();
		model.addAttribute("quizList", quizList);
		model.addAttribute("userToAssign", user);
		return "admin/assignQuiz";
	}

	@RequestMapping("/assignQuiz")
	public String assignQuiz(@RequestParam("userId") User user,
			@RequestParam("quizId") Quiz quiz) {
		Set<Quiz> avaliableQuizes = user.getAvaliableQuizes();
		avaliableQuizes.add(quiz);
		userService.update(user);
		return "redirect:";
	}

	@RequestMapping("/unassignQuiz")
	public String unassignQuiz(@RequestParam("userId") User user,
			@RequestParam("quizId") Quiz quiz) {
		Set<Quiz> avaliableQuizes = user.getAvaliableQuizes();
		avaliableQuizes.remove(quiz);
		userService.update(user);
		return "redirect:";
	}

	@RequestMapping("/registerStudentForm")
	public String viewRegisterStudentForm(Model model) {
		return viewStudentRegisterForm(model, new User());
	}

	private String viewStudentRegisterForm(Model model, User user) {
		model.addAttribute("newUser", user);
		return "admin/registerStudent";
	}

	@RequestMapping("/registerForm")
	public String viewRegisterTutorForm(Model model) {
		return viewRegisterForm(model, new User());
	}

	private String viewRegisterForm(Model model, User user) {
		model.addAttribute("newUser", user);
		model.addAttribute("roles", Role.values());
		return "superadmin/register";
	}

	@RequestMapping("/registerStudent")
	public String registerStudent(@ModelAttribute("newUser") @Valid User user,
			BindingResult result,
			@RequestParam("confirmPassword") String confirmation, Model model,
			RedirectAttributes reditectAttributes) {
		if (result.hasErrors()) {
			return viewStudentRegisterForm(model, user);
		}
		if (!confirmation.equals(user.getPassword())) {
			model.addAttribute("noticeMessage", "PasswordsDiffer");
			return viewStudentRegisterForm(model, user);
		}
		try {
			userService.getByEmail(user.getEmail());
		} catch (NoResultException e) {
			userService.save(user);
			reditectAttributes.addAttribute("succesMessage",
					"StudentRegistered");
			return "redirect:";
		}
		model.addAttribute("noticeMessage", "EmailIsInSystem");
		return viewStudentRegisterForm(model, user);
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("newUser") @Valid User user,
			BindingResult result,
			@RequestParam("confirmPassword") String confirmation, Model model,
			RedirectAttributes reditectAttributes) {
		if (result.hasErrors()) {
			return viewRegisterForm(model, user);
		}
		if (!confirmation.equals(user.getPassword())) {
			model.addAttribute("noticeMessage", "PasswordsDiffer");
			return viewRegisterForm(model, user);
		}
		try {
			userService.getByEmail(user.getEmail());
		} catch (NoResultException e) {
			userService.save(user);
			reditectAttributes.addAttribute("succesMessage", "UserRegistered");
			return "redirect:all";
		}
		model.addAttribute("noticeMessage", "EmailIsInSystem");
		return viewRegisterForm(model, user);
	}

	@RequestMapping("/login")
	public String viewLoginForm() {
		return "login";
	}

	@RequestMapping("/results")
	public String viewUserQuizResults(@ModelAttribute("user") User user,
			Model model) {
		List<QuizResult> quizResults = quizResultService.findByUser(user);
		model.addAttribute("quizResultList", quizResults);
		return "user/quizResults";
	}

	@RequestMapping("info")
	public String viewPersonalInfo(@ModelAttribute User user) {
		if (user.getRole() == Role.ROLE_ADMIN) {
			return "superadmin/personalInfo";
		}
		if (user.getRole() == Role.ROLE_TUTOR) {
			return "admin/personalInfo";

		}
		return "user/personalInfo";
	}

	@RequestMapping("/403")
	public String viewAccessDeniedPage(Model model, @ModelAttribute User user,
			HttpServletRequest request) {
		String path = request.getContextPath() + "/jsp";
		model.addAttribute("goBackUrl",
				user.getRole() == Role.ROLE_STUDENT ? path + "/quiz/avaliable"
						: path + "/quiz/");
		return "403";
	}

}
