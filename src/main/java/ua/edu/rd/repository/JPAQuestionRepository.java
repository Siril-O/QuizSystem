package ua.edu.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.rd.domain.Question;

@Repository
public class JPAQuestionRepository implements QuestionRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Question question) {
		em.persist(question);
	}

	@Override
	public void update(Question question) {
		if (question.getId() != null) {
			em.merge(question);
		}
	}

	@Override
	public Question findById(Long id) {
		return em.find(Question.class, id);
	}

	@Override
	public List<Question> findAllQuestions() {
		TypedQuery<Question> query = em.createNamedQuery(
				"Question.findAllQuestions", Question.class);
		return query.getResultList();
	}

	@Override
	public void remove(Long id) {
		Question question = em.find(Question.class, id);
		if (question != null) {
			em.remove(question);
		}
	}

}
