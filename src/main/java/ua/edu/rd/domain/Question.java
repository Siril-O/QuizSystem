package ua.edu.rd.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({ @NamedQuery(name = "Question.findAllQuestions", query = "SELECT q FROM Question AS q") })
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPTION")
	@NotNull
	@Size(min = 15, max = 1255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;

	@OneToMany(mappedBy = "question", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@OrderBy("ID")
	@Valid
	private List<Variant> variants;

	public Question() {
		super();
	}

	public Question(List<Variant> variants) {
		super();
		this.variants = variants;
	}

	public Question(String description, List<Variant> variants) {
		super();
		this.description = description;
		this.variants = variants;
	}

	public Question(Long id, String description, List<Variant> variants) {
		super();
		this.id = id;
		this.description = description;
		this.variants = variants;
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
	 * @return the variants
	 */
	public List<Variant> getVariants() {
		return variants;
	}

	/**
	 * @param variants
	 *            the variants to set
	 */
	public void setVariants(List<Variant> variants) {
		this.variants = variants;
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
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Question other = (Question) obj;
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
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description
				+ ", variants=" + variants + "]";
	}

}
