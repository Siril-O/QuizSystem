package ua.edu.rd.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@NamedQueries({
		@NamedQuery(name = "QuizResult.findByUser", query = "SELECT qr FROM QuizResult AS qr WHERE qr.user.id=:userId"),
		@NamedQuery(name = "QuizResult.findByQuiz", query = "SELECT qr FROM QuizResult AS qr WHERE qr.quiz.id=:quizId") })
@Entity
@Table(name = "USER_TEST_RESULT")
public class QuizResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@NotNull
	private User user;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "START_TIME")
	@NotNull
	@Past
	private Date startTime;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "END_TIME")
	@NotNull
	private Date endTime;

	@Column(name = "RIGHT_ANSWERS")
	private Integer rightAnswers;

	@Column(name = "WRONG_ANSWERS")
	private Integer wrongAnswers;

	public QuizResult() {
		super();
	}

	public QuizResult(Long id, Quiz quiz, User user, Date startTime,
			Date endTime, Integer rightAnswers, Integer wrongAnswers) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rightAnswers = rightAnswers;
		this.wrongAnswers = wrongAnswers;
	}

	public QuizResult(Quiz quiz, User user, Date startTime, Date endTime,
			Integer rightAnswers, Integer wrongAnswers) {
		super();
		this.quiz = quiz;
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rightAnswers = rightAnswers;
		this.wrongAnswers = wrongAnswers;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the test
	 */
	public Quiz getQuiz() {
		return quiz;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the rightAnswers
	 */
	public Integer getRightAnswers() {
		return rightAnswers;
	}

	/**
	 * @param rightAnswers
	 *            the rightAnswers to set
	 */
	public void setRightAnswers(Integer rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	/**
	 * @return the wrongAnswers
	 */
	public Integer getWrongAnswers() {
		return wrongAnswers;
	}

	/**
	 * @param wrongAnswers
	 *            the wrongAnswers to set
	 */
	public void setWrongAnswers(Integer wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
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
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result
				+ ((rightAnswers == null) ? 0 : rightAnswers.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		QuizResult other = (QuizResult) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (rightAnswers == null) {
			if (other.rightAnswers != null)
				return false;
		} else if (!rightAnswers.equals(other.rightAnswers))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
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
		return "QuizResult [id=" + id + ", quiz=" + quiz + ", user=" + user
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", rightAnswers=" + rightAnswers + ", wrongAnswers="
				+ wrongAnswers + "]";
	}

}
