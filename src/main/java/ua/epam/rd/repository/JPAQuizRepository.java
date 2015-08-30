package ua.epam.rd.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Quiz;

@Repository
public class JPAQuizRepository implements QuizRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Quiz quiz) {
		em.persist(quiz);
	}

}
