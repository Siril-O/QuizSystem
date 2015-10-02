package ua.edu.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Role;
import ua.edu.rd.domain.User;

@Repository
public class JPAUserRepository implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(User user) {
		em.persist(user);
	}

	@Override
	public User findByid(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> getAllUsers(Integer offset, Integer maxResults) {
		TypedQuery<User> query = em.createNamedQuery("User.getAllUsers",
				User.class);
		query.setFirstResult(offset);
		query.setMaxResults(maxResults);
		return query.getResultList();
	}

	@Override
	public List<User> getAllUsersByRole(Role role, Integer offset, Integer maxResults) {
		TypedQuery<User> query = em.createNamedQuery("User.getAllUsersByRole",
				User.class);
		query.setFirstResult(offset);
		query.setMaxResults(maxResults);
		return query.setParameter("role", role).getResultList();
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery(
				"User.getByEmailAndPassword", User.class);
		return query.setParameter("email", email)
				.setParameter("password", password).getSingleResult();
	}

	@Override
	public User getByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.getByEmail",
				User.class);
		return query.setParameter("email", email).getSingleResult();
	}

	@Override
	public void update(User user) {
		if (user.getId() != null) {
			em.merge(user);
		}
	}

	@Override
	public List<User> getUsersAssignedToQuiz(Quiz quiz) {
		TypedQuery<User> query = em.createNamedQuery(
				"User.getUsersAssignedToQuiz", User.class);
		return query.setParameter("quizId", quiz.getId()).getResultList();
	}

	@Override
	public Long getAllUsersTotalResulCount() {
		Query queryTotal = em
				.createNamedQuery("User.getAllUsersTotalResulCount");
		return (long) queryTotal.getSingleResult();
	}

	@Override
	public Long getAllUsersByRoleTotalResulCount(Role role) {
		Query queryTotal = em.createNamedQuery(
				"User.getAllUsersByRoleTotalResulCount").setParameter("role", role);
		return (long) queryTotal.getSingleResult();
	}

}
