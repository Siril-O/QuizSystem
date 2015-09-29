package ua.edu.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.QuizResult;
import ua.edu.rd.domain.User;

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
		TypedQuery<QuizResult> query = em.createNamedQuery(
				"QuizResult.findByUser", QuizResult.class);
		return query.setParameter("userId", user.getId()).getResultList();
	}

	@Override
	public List<QuizResult> findByQuiz(Quiz quiz) {
		TypedQuery<QuizResult> query = em.createNamedQuery(
				"QuizResult.findByQuiz", QuizResult.class);
		return query.setParameter("quizId", quiz.getId()).getResultList();
	}

	@Override
	public void remove(Long id) {
		QuizResult quizResult = em.find(QuizResult.class, id);
		if (quizResult != null) {
			em.remove(quizResult);
		}
	}

}
