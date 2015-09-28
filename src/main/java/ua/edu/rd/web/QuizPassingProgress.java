package ua.edu.rd.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.edu.rd.domain.Question;
import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Variant;

public class QuizPassingProgress {

	private Map<Question, List<Variant>> questionAswerProgress;
	private Quiz quiz;
	private Date startTime;

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public QuizPassingProgress(Quiz quiz) {
		super();
		this.quiz = quiz;
		questionAswerProgress = new HashMap<Question, List<Variant>>();
		startTime = new Date();
	}

	public QuizPassingProgress(
			Map<Question, List<Variant>> questionAswerProgress, Quiz quiz) {
		super();
		this.questionAswerProgress = questionAswerProgress;
		this.quiz = quiz;
	}

	public void finishPassing() {
		questionAswerProgress.clear();
		quiz = null;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */

	/**
	 * @return the questionAswerProgress
	 */
	public Map<Question, List<Variant>> getQuestionAswerProgress() {
		return questionAswerProgress;
	}

	/**
	 * @param questionAswerProgress
	 *            the questionAswerProgress to set
	 */
	public void setQuestionAswerProgress(
			Map<Question, List<Variant>> questionAswerProgress) {
		this.questionAswerProgress = questionAswerProgress;
	}

	/**
	 * @return the quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}

	/**
	 * @param quiz
	 *            the quiz to set
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}
