package ua.edu.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Subject;

@Repository
public class JPAQuizRepository implements QuizRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Quiz quiz) {
		em.persist(quiz);
	}

	@Override
	public Quiz findById(Long id) {
		return em.find(Quiz.class, id);
	}

	@Override
	public List<Quiz> findAllQuizes() {
		TypedQuery<Quiz> query = em.createNamedQuery("Quiz.findAllQuizes",
				Quiz.class);
		return query.getResultList();
	}

	@Override
	public void update(Quiz quiz) {
		if (quiz.getId() != null) {
			em.merge(quiz);
		}
	}

	@Override
	public void remove(Long id) {
		Quiz quiz = em.find(Quiz.class, id);
		if (quiz != null) {
			em.remove(quiz);
		}
	}

	@Override
	public List<Quiz> findQuizesBySubject(Subject subject) {
		TypedQuery<Quiz> query = em.createNamedQuery(
				"Quiz.findQuizesBySubject", Quiz.class);
		return query.setParameter("subjectId", subject.getId()).getResultList();
	}

}
