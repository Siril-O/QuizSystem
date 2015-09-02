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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@NamedQueries({ @NamedQuery(name = "Quiz.findAllQuizes", query = "SELECT q FROM Quiz AS q") })
@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@OneToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	// @ManyToMany
	// @JoinTable(name = "QUIZ_QUESTIONS",
	// joinColumns = { @JoinColumn(name = "QUIZ_ID") },
	// inverseJoinColumns = { @JoinColumn(name = "QUESTION_ID") })
	// private List<Question> questions;
	@OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("ID")
	private Set<Question> questions;

	public Quiz() {
		super();
	}

	public Quiz(Long id, String name, Subject subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	public Quiz(String name, Subject subject) {
		super();
		this.name = name;
		this.subject = subject;
	}

	public Quiz(String name, Subject subject, Set<Question> questions) {
		super();
		this.name = name;
		this.subject = subject;
		this.questions = questions;
	}

	public Quiz(Long id, String name, Subject subject, Set<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.questions = questions;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", name=" + name + ", subject=" + subject
				+ ", questions=" + questions + "]";
	}

}
