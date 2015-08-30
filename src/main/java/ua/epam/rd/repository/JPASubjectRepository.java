package ua.epam.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Subject;

@Repository
public class JPASubjectRepository implements SubjectRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Subject subject) {
		em.persist(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {

		TypedQuery<Subject> query = em.createNamedQuery(
				"Subject.getAllSubjects", Subject.class);
		return query.getResultList();
	}

}
