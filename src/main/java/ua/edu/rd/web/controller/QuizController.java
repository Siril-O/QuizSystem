package ua.edu.rd.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Subject;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends AbstractController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showQuizes(Model model) {
		return viewAllQuizes(model);
	}

	private String viewAllQuizes(Model model) {
		List<Quiz> quizes = quizService.findAllQuizes();
		model.addAttribute("quizList", quizes);
		return "admin/quiz";
	}

	@RequestMapping(value = "add")
	public String viewAddQuizForm(Model model) {
		return viewCreateQuizForm(model, new Quiz());
	}

	private String viewCreateQuizForm(Model model, Quiz quiz) {
		model.addAttribute("subjects", subjectService.getAllSubjects());
		model.addAttribute("quiz", quiz);
		return "admin/addQuiz";
	}

	@RequestMapping(value = "create")
	public String createQuiz(@RequestParam("subjectId") Subject subject,
			@ModelAttribute @Valid Quiz quiz, BindingResult bindResult,
			Model model) {
		if (bindResult.hasErrors()) {
			return viewCreateQuizForm(model, quiz);
		}
		quiz.setSubject(subject);
		quizService.save(quiz);
		model.addAttribute("succesMessage", "QuizSuccesfullyCreated");
		return viewAllQuizes(model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditForm(
			@RequestParam("quizId") Quiz quiz,
			@RequestParam(value = "succesMessage", required = false) String message,
			Model model) {
		model.addAttribute("succesMessage", message);
		return viewEditForm(quiz, model);
	}

	private String viewEditForm(Quiz quiz, Model model) {
		model.addAttribute("quiz", quiz);
		model.addAttribute("subjects", subjectService.getAllSubjects());
		return "admin/editQuiz";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeQuiz(
			@RequestParam("quizId") Long quizId,
			@RequestParam(value = "confirm", defaultValue = "false") boolean confirm,
			Model model) {
		if (confirm) {
			quizService.remove(quizId);
			model.addAttribute("succesMessage", "QuizRemoved");
		} else {
			model.addAttribute("noticeMessage", "ConfirmQuizRemoved");
		}
		return viewAllQuizes(model);
	}

	@RequestMapping(value = "/changeName", method = RequestMethod.POST)
	public String editQuiz(@RequestParam("quizId") Quiz quiz,
			@ModelAttribute("quiz") @Valid Quiz newQuiz,
			BindingResult bindingResult, Model model) {
		if (!bindingResult.hasFieldErrors("name")) {
			quiz.setName(newQuiz.getName());
			quizService.update(quiz);

			model.addAttribute("succesMessage", "QuizNameUpdated");
		}
		model.addAttribute("noticeMessage", "NotValidQuizName");
		return viewEditForm(quiz, model);
	}

	@RequestMapping(value = "/changeSubject", method = RequestMethod.POST)
	public String editQuiz(@RequestParam("subjectId") Subject subject,
			@RequestParam("quizId") Quiz quiz, Model model) {
		quiz.setSubject(subject);
		quizService.update(quiz);
		model.addAttribute("succesMessage", "SubjectUpdated");
		return viewEditForm(quiz, model);
	}

	@RequestMapping("/avaliable")
	public String viewAvaliableQuizes(Model model) {
		return "user/avaliableQuizes";
	}
}
