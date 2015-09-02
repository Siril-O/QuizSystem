package ua.epam.rd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;

@Controller
@RequestMapping("question")
public class QuestionController extends AbstractController {

	@RequestMapping(value = "/add")
	public String viewQuestionAddingForm(@RequestParam("quizId") Quiz quiz,
			Model model) {
		model.addAttribute("quiz", quiz);
		return "addQuestion";
	}

	@RequestMapping(value = "/create")
	public String addQuestion(@RequestParam("quizId") Quiz quiz,
			@ModelAttribute Question question, Model model) {
		question.setQuiz(quiz);
		questionService.save(question);
		return "redirect:" + "../quiz/edit?quizId="
				+ question.getQuiz().getId();
	}

	@RequestMapping(value = "/update")
	public String editQuestion(@RequestParam("questionId") Question question,
			@RequestParam String description, Model model) {
		question.setDescription(description);
		questionService.update(question);
		return "redirect:" + "../quiz/edit?quizId="
				+ question.getQuiz().getId();
	}

	@RequestMapping(value = "/remove")
	public String removeQuestion(@RequestParam("questionId") Question question,
			@RequestParam(value="confirm",defaultValue="false") boolean confirm) {
		System.out.println("*********" + confirm);
		if (confirm) {
			question.getQuiz().getQuestions().remove(question);
			questionService.remove(question.getId());
		}
		return "redirect:" + "../quiz/edit?quizId="
				+ question.getQuiz().getId();
	}

}
