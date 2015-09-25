package ua.epam.rd.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.User;
import ua.epam.rd.domain.Variant;

@Component
public class QuizPassingResultCalculator {

	public QuizResult calculateResult(QuizPassingProgress progress, User user,
			Date endDate) {

		Map<Question, List<Variant>> answerProgress = progress
				.getQuestionAswerProgress();

		if (!progress.getQuiz().getQuestions().equals(answerProgress.keySet())) {
			throw new IllegalArgumentException();
		}

		int rightAnswers = 0;
		int wrongAnswers = 0;
		for (Entry<Question, List<Variant>> entry : answerProgress.entrySet()) {
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
		QuizResult quizResult = new QuizResult(progress.getQuiz(), user,
				progress.getStartTime(), endDate, rightAnswers, wrongAnswers);
		return quizResult;

	}
}
