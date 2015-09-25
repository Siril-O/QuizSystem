package ua.epam.rd.web.controller;

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

import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.Role;
import ua.epam.rd.domain.User;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

	@RequestMapping("/")
	public String showStudents(Model model) {
		List<User> users = userService.getAllUsersByRole(Role.ROLE_STUDENT);
		model.addAttribute("users", users);
		return "admin/user";
	}

	@RequestMapping("/all")
	public String showUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "superadmin/users";
	}

	@RequestMapping("/edit")
	public String viewEditForm(Model model, @RequestParam("userId") User user) {
		model.addAttribute("userToEdit", user);
		return "admin/editUser";
	}

	@RequestMapping("/update")
	public String updateUser(@RequestParam("id") User oldUser,
			@ModelAttribute("newUser") User user) {
		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());
		userService.update(user);
		return "redirect:";
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
	public String viewRegisterForm(Model model) {
		model.addAttribute("newUser", new User());
		return "admin/registerStudent";
	}

	@RequestMapping("/registerForm")
	public String viewRegisterTutorForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("roles", Role.values());
		return "superadmin/register";
	}

	@RequestMapping("/registerStudent")
	public String registerStudent(@ModelAttribute("newUser") @Valid User user,
			BindingResult result,
			@RequestParam("confirmPassword") String confirmation, Model model) {
		return registerUser(user, result, confirmation,
				"admin/registerStudent", model);
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("newUser") @Valid User user,
			BindingResult result,
			@RequestParam("confirmPassword") String confirmation, Model model) {
		return registerUser(user, result, confirmation, "superadmin/register",
				model);
	}

	private String registerUser(User user, BindingResult result,
			String confirmation, String destPage, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("newUser", user);
			return destPage;
		}
		if (!confirmation.equals(user.getPassword())) {
			model.addAttribute("newUser", user);
			model.addAttribute("ErrorMsg", "You entered different passwords");
			return destPage;
		}
		try {
			userService.getByEmail(user.getEmail());
		} catch (NoResultException e) {
			userService.save(user);
			return "redirect:";
		}
		model.addAttribute("newUser", user);
		model.addAttribute("ErrorMsg", "Email already registered in  system");
		return destPage;
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
