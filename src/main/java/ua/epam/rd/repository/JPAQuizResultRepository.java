package ua.epam.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.User;

@Repository
public class JPAQuizResultRepository implements QuizResultRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(QuizResult quizResult) {
		em.persist(quizResult);
	}

	@Override
	public QuizResult findById(Long id) {
		return em.find(QuizResult.class, id);
	}

	@Override
	public List<QuizResult> findByUser(User user) {
		TypedQuery<QuizResult> query = em
				.createNamedQuery("QuizResult.findByUser", QuizResult.class);
		return query.setParameter("userId", user.getId()).getResultList();
	}

}
