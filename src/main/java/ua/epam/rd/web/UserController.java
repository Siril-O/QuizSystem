package ua.epam.rd.web;

import java.util.List;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showUsers(Model model) {
		List<User> users = userService.getAllUsersByRole(Role.ROLE_USER);
		model.addAttribute("users", users);
		return "admin/user";
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
		model.addAttribute("user", user);
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

	@RequestMapping("/registerForm")
	public String viewRegisterForm(Model model) {
		return "admin/register";
	}

	@RequestMapping("/register")
	public String viewRegisterForm(@ModelAttribute("newUser") User user,
			@RequestParam("confirmPassword") String confirmation, Model model) {
		if (!confirmation.equals(user.getPassword())) {
			return "admin/register";
		}
		try {
			user.setRole(Role.ROLE_USER);
			userService.save(user);
		} catch (ConstraintViolationException e) {
			System.out.println("User already exsist");
		}
		return "redirect:";
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
	public String viewPersonalInfo(Model model) {
		return "user/personalInfo";
	}

}
