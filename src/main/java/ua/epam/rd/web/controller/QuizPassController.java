package ua.epam.rd.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.User;
import ua.epam.rd.domain.Variant;
import ua.epam.rd.web.QuizPassingProgress;
import ua.epam.rd.web.QuizPassingResultCalculator;

@Controller
@RequestMapping("pass")
@SessionAttributes({ "progress" })
public class QuizPassController extends AbstractController {

	@Autowired
	private QuizPassingResultCalculator resultCalculator;

	@RequestMapping("/quiz")
	public String viewPassQuizForm(Model model,
			@RequestParam("quizId") Quiz quiz,
			RedirectAttributes redirectAttributes) {
		if (!model.containsAttribute("progress")) {
			model.addAttribute("progress", new QuizPassingProgress(quiz));
			Question question = quiz.getQuestions().iterator().next();
			model.addAttribute("question", question);
		} else {
			redirectAttributes.addAttribute("quizId", quiz.getId());
			return "redirect:proceed";
		}
		return "user/passQuestion";
	}

	@RequestMapping("/proceed")
	public String proccedPassingQuiz(
			@ModelAttribute("progress") QuizPassingProgress progress,
			@RequestParam(value = "quizId", required = false) Quiz quiz,
			Model model) {
		if (progress.getQuiz() == null) {
			progress.setQuiz(quiz);
		}
		model.addAttribute("question", getNextQuestionFromQuiz(progress));
		return "user/passQuestion";
	}

	@RequestMapping("/question")
	public String addAnswerOnQuestion(Model model,
			@RequestParam("questionId") Question question,
			@RequestParam("choosedVariants") List<Variant> choosedVariants,
			@ModelAttribute("progress") QuizPassingProgress progress,
			@ModelAttribute("user") User user) {

		progress.getQuestionAswerProgress().put(question, choosedVariants);
		Question nextQuestion = getNextQuestionFromQuiz(progress);
		if (nextQuestion != null) {
			model.addAttribute("question", nextQuestion);
			return "user/passQuestion";
		} else {
			QuizResult quizResult = resultCalculator.calculateResult(progress,
					user, new Date());
			quizResultService.save(quizResult);
			return viewExtendedQuizResultPassing(model, progress, quizResult);
		}
	}

	private Question getNextQuestionFromQuiz(QuizPassingProgress progress) {
		for (Question question : progress.getQuiz().getQuestions()) {
			if (!progress.getQuestionAswerProgress().containsKey(question)) {
				return question;
			}
		}
		return null;
	}

	private String viewExtendedQuizResultPassing(Model model,
			QuizPassingProgress progress, QuizResult quizResult) {
		Map<Question, Map<Variant, Boolean>> resultMap = getMapOfChoosedVariantsAndRightVariants(progress);
		progress.finishPassing();
		model.addAttribute("result", quizResult);
		model.addAttribute("resultMap", resultMap);
		return "user/quizExtendedResult";

	}

	private Map<Question, Map<Variant, Boolean>> getMapOfChoosedVariantsAndRightVariants(
			QuizPassingProgress progress) {
		Map<Question, Map<Variant, Boolean>> resultMap = new LinkedHashMap<>();
		for (Question question : progress.getQuiz().getQuestions()) {
			Map<Variant, Boolean> resultVariants = new HashMap<>();
			for (Variant v : question.getVariants()) {
				resultVariants.put(v,
						progress.getQuestionAswerProgress().get(question)
								.contains(v));
			}
			resultMap.put(question, resultVariants);
		}
		return resultMap;
	}
}
