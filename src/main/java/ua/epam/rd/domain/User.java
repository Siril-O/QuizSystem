package ua.epam.rd.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="FIRST_NAME")
	private String name;
	@Column(name="LAST_NAME")
	private String surname;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToMany
	@JoinTable(name="USER_AVALIABLE_QUIZ",
				joinColumns={@JoinColumn(name="USER_ID")},
				inverseJoinColumns={@JoinColumn(name="QUIZ_ID")})
	private List<Quiz> avaliableQuizes;
	
	@OneToMany(mappedBy="user")
	private List<QuizResult> quizResults;
	
	
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
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
	 * @param email the email to set
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
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the avaliableQuizes
	 */
	public List<Quiz> getAvaliableQuizes() {
		return avaliableQuizes;
	}

	/**
	 * @param avaliableQuizes the avaliableQuizes to set
	 */
	public void setAvaliableQuizes(List<Quiz> avaliableQuizes) {
		this.avaliableQuizes = avaliableQuizes;
	}

	/**
	 * @return the quizResults
	 */
	public List<QuizResult> getQuizResults() {
		return quizResults;
	}

	/**
	 * @param quizResults the quizResults to set
	 */
	public void setQuizResults(List<QuizResult> quizResults) {
		this.quizResults = quizResults;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	
}
