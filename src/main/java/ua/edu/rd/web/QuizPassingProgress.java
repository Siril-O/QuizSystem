package ua.edu.rd.web;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
		questionAswerProgress = new ConcurrentHashMap<Question, List<Variant>>();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((questionAswerProgress == null) ? 0 : questionAswerProgress
						.hashCode());
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizPassingProgress other = (QuizPassingProgress) obj;
		if (questionAswerProgress == null) {
			if (other.questionAswerProgress != null)
				return false;
		} else if (!questionAswerProgress.equals(other.questionAswerProgress))
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuizPassingProgress [questionAswerProgress="
				+ questionAswerProgress + ", quiz=" + quiz + ", startTime="
				+ startTime + "]";
	}

}
