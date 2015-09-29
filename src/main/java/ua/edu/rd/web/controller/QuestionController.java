package ua.edu.rd.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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
import ua.edu.rd.domain.Variant;

@Controller
@RequestMapping("question")
public class QuestionController extends AbstractController {

	@RequestMapping(value = "/editForm")
	public String viewQuestionEdit(
			@RequestParam("questionId") Question question,
			@RequestParam(value = "succesMessage", required = false) String message,
			Model model) {
		model.addAttribute("succesMessage", message);
		return viewEditQuestionForm(question, model);
	}

	private String viewEditQuestionForm(Question question, Model model) {
		model.addAttribute("question", question);
		return "admin/editQuestion";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String viewQuestionAddingForm(@RequestParam("quizId") Quiz quiz,
			Model model) {
		List<Variant> variants = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			variants.add(new Variant());
		}
		return viewQuestionCreationForm(quiz, new Question(variants), model);
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
			BindingResult bindResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindResult.hasErrors()) {
			return viewQuestionCreationForm(quiz, question, model);
		}
		if (!checkIfRightVariantPresent(question.getVariants())) {
			model.addAttribute("noticeMessage", "NoRightVariant");
			return viewQuestionCreationForm(quiz, question, model);
		}
		for (Variant variant : question.getVariants()) {
			variant.setQuestion(question);
		}
		question.setQuiz(quiz);
		questionService.save(question);
		redirectAttributes.addAttribute("succesMessage", "QuestionCreated");
		redirectAttributes.addAttribute("quizId", quiz.getId());
		return "redirect:../quiz/edit";
	}

	private boolean checkIfRightVariantPresent(List<Variant> variants) {
		for (Variant variant : variants) {
			if (variant.getRightAnswer()) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editQuestion(@RequestParam("quizId") Quiz quiz,
			@ModelAttribute("question") @Valid Question newQuestion,
			BindingResult bindResult, RedirectAttributes redirectAttributes,
			Model model) {
		newQuestion.setQuiz(quiz);
		if (bindResult.hasErrors()) {
			return viewEditQuestionForm(newQuestion, model);
		}
		if (!checkIfRightVariantPresent(newQuestion.getVariants())) {
			model.addAttribute("noticeMessage", "NoRightVariant");
			return viewEditQuestionForm(newQuestion, model);
		}
		for (Variant variant : newQuestion.getVariants()) {
			variant.setQuestion(newQuestion);
		}
		questionService.update(newQuestion);
		redirectAttributes.addAttribute("succesMessage", "QuestionUpdated");
		redirectAttributes.addAttribute("questionId", newQuestion.getId());
		return "redirect:editForm";
	}

	@RequestMapping(value = "/remove")
	public String removeQuestion(
			@RequestParam("questionId") Question question,
			@RequestParam(value = "confirm", defaultValue = "false") boolean confirm,
			RedirectAttributes redirectAttributes) {
		if (confirm) {
			question.getQuiz().getQuestions().remove(question);
			questionService.remove(question.getId());
			redirectAttributes.addAttribute("succesMessage", "QuestionRemoved");
		}
		redirectAttributes.addAttribute("quizId", question.getQuiz().getId());
		return "redirect:../quiz/edit";
	}
}
