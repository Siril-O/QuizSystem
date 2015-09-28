package ua.edu.rd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "Variant.fiandAllVariants", query = "SELECT v FROM Variant AS v") })
@Entity
public class Variant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	private Question question;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "RIGHT_ANSWER")
	private Boolean rightAnswer;

	public Variant() {
		super();
	}

	public Variant(String description, Boolean rightAnswer) {
		super();
		this.description = description;
		this.rightAnswer = rightAnswer;
	}

	public Variant(Long id, Question question, String description,
			Boolean rightAnswer) {
		super();
		this.id = id;
		this.question = question;
		this.description = description;
		this.rightAnswer = rightAnswer;
	}

	public Variant(Question question, String description, Boolean rightAnswer) {
		super();
		this.question = question;
		this.description = description;
		this.rightAnswer = rightAnswer;
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
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the rightAnswer
	 */
	public Boolean getRightAnswer() {
		return rightAnswer;
	}

	/**
	 * @param rightAnswer
	 *            the rightAnswer to set
	 */
	public void setRightAnswer(Boolean rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Variant [id=" + id + ", description=" + description
				+ ", rightAnswer=" + rightAnswer + "]";
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
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((rightAnswer == null) ? 0 : rightAnswer.hashCode());
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
		Variant other = (Variant) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rightAnswer == null) {
			if (other.rightAnswer != null)
				return false;
		} else if (!rightAnswer.equals(other.rightAnswer))
			return false;
		return true;
	}

}
