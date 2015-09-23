package ua.epam.rd.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@NamedQueries({
		@NamedQuery(name = "User.getAllUsers", query = "SELECT u FROM User AS u"),
		@NamedQuery(name = "User.getAllUsersByRole", query = "SELECT u FROM User AS u WHERE u.role=:role"),
		@NamedQuery(name = "User.getByEmailAndPassword", query = "SELECT u FROM User AS u WHERE u.email=:email AND u.password=:password"),
		@NamedQuery(name = "User.getByEmail", query = "SELECT u FROM User AS u WHERE u.email=:email") })
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "EMAIL") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	@NotNull
	@Size(min = 2, max = 30)
	private String name;
	@Column(name = "LAST_NAME")
	@Size(min = 2, max = 60)
	private String surname;
	@Column(name = "EMAIL")
	@NotNull
	@Email
	private String email;
	@Column(name = "PASSWORD")
	@NotNull
	private String password;
	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_AVALIABLE_QUIZ", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "QUIZ_ID") })
	private Set<Quiz> avaliableQuizes;

	@OneToMany(mappedBy = "user")
	private Set<QuizResult> quizResults;

	public User(String name, String surname, String email, String password,
			Role role) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the avaliableQuizes
	 */
	public Set<Quiz> getAvaliableQuizes() {
		return avaliableQuizes;
	}

	/**
	 * @param avaliableQuizes
	 *            the avaliableQuizes to set
	 */
	public void setAvaliableQuizes(Set<Quiz> avaliableQuizes) {
		this.avaliableQuizes = avaliableQuizes;
	}

	/**
	 * @return the quizResults
	 */
	public Set<QuizResult> getQuizResults() {
		return quizResults;
	}

	/**
	 * @param quizResults
	 *            the quizResults to set
	 */
	public void setQuizResults(Set<QuizResult> quizResults) {
		this.quizResults = quizResults;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}

}
