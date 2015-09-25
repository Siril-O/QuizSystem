package ua.epam.rd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;

@Controller
@RequestMapping("question")
public class QuestionController extends AbstractController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String viewQuestionAddingForm(@RequestParam("quizId") Quiz quiz,
			Model model) {
		model.addAttribute("quiz", quiz);
		return "admin/addQuestion";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addQuestion(@RequestParam("quizId") Quiz quiz,
			@ModelAttribute Question question, Model model,
			RedirectAttributes redirectAttributes) {
		question.setQuiz(quiz);
		questionService.save(question);
		redirectAttributes.addAttribute("quizId", question.getQuiz().getId());
		return "redirect:../quiz/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editQuestion(@RequestParam("questionId") Question question,
			@RequestParam String description, Model model,
			RedirectAttributes redirectAttributes) {
		question.setDescription(description);
		questionService.update(question);
		redirectAttributes.addAttribute("quizId", question.getQuiz().getId());
		return "redirect:../quiz/edit";
	}

	@RequestMapping(value = "/remove")
	public String removeQuestion(
			@RequestParam("questionId") Question question,
			@RequestParam(value = "confirm", defaultValue = "false") boolean confirm,
			RedirectAttributes redirectAttributes) {
		if (confirm) {
			question.getQuiz().getQuestions().remove(question);
			questionService.remove(question.getId());
		}
		redirectAttributes.addAttribute("quizId", question.getQuiz().getId());
		return "redirect:../quiz/edit";
	}
}
