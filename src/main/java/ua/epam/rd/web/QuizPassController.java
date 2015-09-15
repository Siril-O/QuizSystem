package ua.epam.rd.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.User;
import ua.epam.rd.domain.Variant;

@Controller
@RequestMapping("pass")
@SessionAttributes({ "quizPassingProgress", "startTime" })
public class QuizPassController extends AbstractController {

	@RequestMapping("/quiz")
	public String viewPassQuizForm(Model model,
			@RequestParam("quizId") Quiz quiz) {
		model.addAttribute("quizPassingProgress",
				new HashMap<Question, List<Variant>>());
		model.addAttribute("startTime", new Date());
		Question question = quiz.getQuestions().iterator().next();
		model.addAttribute("question", question);
		return "user/passQuestion";
	}

	@RequestMapping("/question")
	public String getAnsverOnQuestion(
			Model model,
			@RequestParam("questionId") Question question,
			@RequestParam("choosedVariants") List<Variant> choosedVariants,
			@ModelAttribute("quizPassingProgress") Map<Question, List<Variant>> progress,
			@ModelAttribute("startTime") Date startTime,
			@ModelAttribute("user") User user) {
		progress.put(question, choosedVariants);
		Quiz quiz = question.getQuiz();
		Question nextQuestion = getNextQuestionFromQuiz(question, quiz);
		if (nextQuestion != null) {
			model.addAttribute("question", nextQuestion);
			return "user/passQuestion";
		} else {
			QuizResult quizResult = saveQuizPassingResult(quiz, user, progress,
					startTime);
			return viewExtendedQuizResultPassing(model, quiz, progress,
					quizResult);
		}
	}

	private Question getNextQuestionFromQuiz(Question currentQuestion, Quiz quiz) {
		Question nextQuestion = null;
		Iterator<Question> iterator = quiz.getQuestions().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(currentQuestion)) {
				nextQuestion = iterator.hasNext() ? iterator.next() : null;
			}
		}
		return nextQuestion;
	}

	private QuizResult saveQuizPassingResult(Quiz quiz, User user,
			Map<Question, List<Variant>> progress, Date startTime) {
		int rightAnswers = 0;
		int wrongAnswers = 0;
		for (Entry<Question, List<Variant>> entry : progress.entrySet()) {
			List<Variant> rightVariants = new ArrayList<>();
			for (Variant variant : entry.getKey().getVariants()) {
				if (variant.getRightAnswer()) {
					rightVariants.add(variant);
				}
			}
			if (rightVariants.equals(entry.getValue())) {
				rightAnswers++;
			} else {
				wrongAnswers++;
			}
		}
		QuizResult quizResult = new QuizResult(quiz, user, startTime,
				new Date(), rightAnswers, wrongAnswers);
		quizResultService.save(quizResult);
		return quizResult;
	}

	private String viewExtendedQuizResultPassing(Model model, Quiz quiz,
			Map<Question, List<Variant>> progress, QuizResult quizResult) {
		Map<Question, Map<Variant, Boolean>> resultMap = getMapOfChoosedVariantsAndRightVariants(
				quiz, progress);
		progress.clear();
		model.addAttribute("result", quizResult);
		model.addAttribute("resultMap", resultMap);
		return "user/quizExtendedResult";

	}

	private Map<Question, Map<Variant, Boolean>> getMapOfChoosedVariantsAndRightVariants(
			Quiz quiz, Map<Question, List<Variant>> progress) {
		Map<Question, Map<Variant, Boolean>> resultMap = new LinkedHashMap<>();
		for (Question question : quiz.getQuestions()) {
			Map<Variant, Boolean> resultVariants = new HashMap<>();
			for (Variant v : question.getVariants()) {
				resultVariants.put(v, progress.get(question).contains(v));
			}
			resultMap.put(question, resultVariants);
		}
		return resultMap;
	}
}
