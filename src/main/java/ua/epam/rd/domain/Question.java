package ua.epam.rd.domain;

import java.util.Set;

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

@NamedQueries({ @NamedQuery(name = "Question.findAllQuestions", query = "SELECT q FROM Question AS q") })
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPTION")
	private String description;
	// @Column(name = "ORDER")
	// private Long order;
	// To do

	@ManyToOne()
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;

	@OneToMany(mappedBy = "question", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@OrderBy("ID")
	private Set<Variant> variants;

	public Question() {
		super();
	}

	public Question(String description, Set<Variant> variants) {
		super();
		this.description = description;
		this.variants = variants;
	}

	public Question(Long id, String description, Set<Variant> variants) {
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
	public Set<Variant> getVariants() {
		return variants;
	}

	/**
	 * @param variants
	 *            the variants to set
	 */
	public void setVariants(Set<Variant> variants) {
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description
				+ ", variants=" + variants + "]";
	}

}
