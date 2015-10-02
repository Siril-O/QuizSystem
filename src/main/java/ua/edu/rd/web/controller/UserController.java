package ua.edu.rd.web.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
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

	private static final int DEFAULT_OFFSET = 0;
	private static final int DEFAULT_MAX_RESULTS = 5;

	@RequestMapping("/")
	public String showStudents(
			@RequestParam(value = "succesMessage", required = false) String message,
			@RequestParam(value = "offset", required = false) Integer offset,
			Model model) {
		model.addAttribute("users", userService.getAllUsersByRole(
				Role.ROLE_STUDENT, offset, DEFAULT_MAX_RESULTS));
		preparePaging(offset, model, userService.getAllUsersByRolePagesNumber(
				Role.ROLE_STUDENT, DEFAULT_MAX_RESULTS));
		model.addAttribute("succesMessage", message);
		return "admin/user";
	}

	private void preparePaging(Integer offset, Model model, Long pagesNumber) {
		model.addAttribute("maxResults", DEFAULT_MAX_RESULTS);
		model.addAttribute("offset", offset != null ? offset : DEFAULT_OFFSET);
		model.addAttribute("pagesNumber", pagesNumber);
	}

	@RequestMapping("/all")
	public String showUsers(
			@RequestParam(value = "succesMessage", required = false) String message,
			@RequestParam(value = "offset", required = false) Integer offset,
			Model model) {
		model.addAttribute("users",
				userService.getAllUsers(offset, DEFAULT_MAX_RESULTS));
		preparePaging(offset, model,
				userService.getAllUsersPagesNumber(DEFAULT_MAX_RESULTS));
		model.addAttribute("succesMessage", message);
		return "superadmin/users";
	}

	@RequestMapping("/edit")
	public String viewEditForm(Model model,
			@RequestParam(value = "userId", required = false) User user,
			@ModelAttribute("user") User signedInUser) {
		if (user == null) {
			return "redirect:"
					+ (signedInUser.getRole() == Role.ROLE_ADMIN ? "all" : "");
		}
		return viewUserEditForm(user, model, signedInUser);
	}

	private String viewUserEditForm(User user, Model model, User signedInUser) {
		model.addAttribute("userToEdit", user);
		if (signedInUser.getRole() == Role.ROLE_ADMIN) {
			return "superadmin/editUser";
		} else {
			return "admin/editUser";
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
		return viewQuizesForAssigment(user, model);
	}

	private String viewQuizesForAssigment(User user, Model model) {
		List<Quiz> quizes = quizService.findAllQuizes();
		for (Iterator<Quiz> iter = quizes.iterator(); iter.hasNext();) {
			if (iter.next().getQuestions().isEmpty()) {
				iter.remove();
			}
		}
		model.addAttribute("quizList", quizes);
		model.addAttribute("userToAssign", user);
		return "admin/assignQuiz";
	}

	@RequestMapping("/assignQuiz")
	public String assignQuiz(@RequestParam("userId") User user,
			@RequestParam("quizId") Quiz quiz, Model model) {
		if (quiz.getQuestions().isEmpty()) {
			model.addAttribute("noticeMessage", "QuizContainsNoQuestions");
			return viewQuizesForAssigment(user, model);
		}
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
		System.out.println("************** " + avaliableQuizes);
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

	@RequestMapping("/removeResult")
	public String removeResult(@RequestParam("resultId") Long id,
			@RequestParam("userId") Long userId,
			RedirectAttributes reditectAttribute) {
		quizResultService.remove(id);
		reditectAttribute.addAttribute("succesMessage", "ResultRemoved");
		reditectAttribute.addAttribute("userId", userId);
		return "redirect:resultsForTutor";
	}

	@RequestMapping("/results")
	public String viewUserQuizResults(@ModelAttribute("user") User user,
			Model model) {
		List<QuizResult> quizResults = quizResultService.findByUser(user);
		model.addAttribute("quizResultList", quizResults);
		return "user/quizResults";
	}

	@RequestMapping("/resultsForTutor")
	public String viewUserQuizResultsForTutor(
			@RequestParam("userId") User user,
			Model model,
			@RequestParam(value = "succesMessage", required = false) String message) {
		List<QuizResult> quizResults = quizResultService.findByUser(user);
		model.addAttribute("quizResultList", quizResults);
		model.addAttribute("succesMessage", message);
		return "admin/quizResults";
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

}
