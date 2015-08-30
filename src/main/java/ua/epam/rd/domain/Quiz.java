package ua.epam.rd.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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

	@ManyToMany
	@JoinTable(name = "QUIZ_QUESTIONS",
				joinColumns = { @JoinColumn(name = "QUIZ_ID") },
				inverseJoinColumns = { @JoinColumn(name = "QUESTION_ID") })
	private List<Question> questions;
	
	public Quiz() {
		super();
	}

	
	public Quiz(Long id, String name, Subject subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}


	public Quiz(String name, Subject subject, List<Question> questions) {
		super();
		this.name = name;
		this.subject = subject;
		this.questions = questions;
	}

	public Quiz(Long id, String name, Subject subject, List<Question> questions) {
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
	 * @param id the id to set
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
	 * @param name the name to set
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
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
}
