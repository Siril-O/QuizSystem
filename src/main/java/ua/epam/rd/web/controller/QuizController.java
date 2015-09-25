package ua.epam.rd.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.Subject;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends AbstractController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showQuizes(Model model) {
		List<Quiz> quizes = quizService.findAllQuizes();
		model.addAttribute("quizList", quizes);
		return "admin/quiz";
	}

	@RequestMapping(value = "add")
	public String viewAddQuizForm(Model model) {
		model.addAttribute("subjects", subjectService.getAllSubjects());
		return "admin/addQuiz";
	}

	@RequestMapping(value = "create")
	public String createQuiz(@RequestParam("subjectId") Subject subject,
			@ModelAttribute Quiz quiz, Model model) {
		quiz.setSubject(subject);
		quizService.save(quiz);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditForm(@RequestParam("quizId") Quiz quiz, Model model) {
		model.addAttribute("quiz", quiz);
		model.addAttribute("subjects", subjectService.getAllSubjects());
		return "admin/editQuiz";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeQuiz(
			@RequestParam("quizId") Long quizId,
			@RequestParam(value = "confirm", defaultValue = "false") boolean confirm) {
		if (confirm) {
			quizService.remove(quizId);
		}
		return "redirect:";
	}

	@RequestMapping(value = "/changeName", method = RequestMethod.POST)
	public String editQuiz(@RequestParam("name") String name,
			@RequestParam("quizId") Quiz quiz,
			RedirectAttributes redirectAttributes) {
		quiz.setName(name);
		quizService.update(quiz);
		redirectAttributes.addAttribute("quizId", quiz.getId());
		return "redirect:edit";
	}

	@RequestMapping(value = "/changeSubject", method = RequestMethod.POST)
	public String editQuiz(@RequestParam("subjectId") Subject subject,
			@RequestParam("quizId") Quiz quiz,
			RedirectAttributes redirectAttributes) {
		quiz.setSubject(subject);
		quizService.update(quiz);
		redirectAttributes.addAttribute("quizId", quiz.getId());
		return "redirect:edit";
	}

	@RequestMapping("/avaliable")
	public String viewAvaliableQuizes(Model model) {
		return "user/avaliableQuizes";
	}
}
