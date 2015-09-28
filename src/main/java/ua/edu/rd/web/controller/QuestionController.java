package ua.edu.rd.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.edu.rd.domain.Question;
import ua.edu.rd.domain.Quiz;

@Controller
@RequestMapping("question")
public class QuestionController extends AbstractController {

	@Autowired
	private QuizController quizController;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String viewQuestionAddingForm(@RequestParam("quizId") Quiz quiz,
			Model model) {
		return viewQuestionCreationForm(quiz, new Question(), model);
	}

	private String viewQuestionCreationForm(Quiz quiz, Question question,
			Model model) {
		model.addAttribute("quiz", quiz);
		model.addAttribute("question", question);
		return "admin/addQuestion";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addQuestion(@RequestParam("quizId") Quiz quiz,
			@ModelAttribute("question") @Valid Question question,
			BindingResult bindResult, Model model) {
		if (bindResult.hasErrors()) {
			return viewQuestionCreationForm(quiz, question, model);
		}
		question.setQuiz(quiz);
		questionService.save(question);
		model.addAttribute("succesMessage", "QuestionCreated");
		return quizController.viewEditForm(quiz, model);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editQuestion(
			@RequestParam("questionId") @Valid Question question,
			BindingResult result, @RequestParam String description,
			Model model, RedirectAttributes redirectAttributes) {
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
