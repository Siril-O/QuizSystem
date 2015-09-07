package ua.epam.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Role;
import ua.epam.rd.domain.User;

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
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("User.getAllUsers",
				User.class);
		return query.getResultList();
	}

	@Override
	public List<User> getAllUsersByRole(Role role) {
		TypedQuery<User> query = em.createNamedQuery("User.getAllUsersByRole",
				User.class);
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

}
