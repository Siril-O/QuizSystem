package ua.edu.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.rd.domain.Subject;

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

	@Override
	public Subject findById(Long id) {
		return em.find(Subject.class, id);
	}

	@Override
	public void update(Subject subject) {
		if (subject.getId() != null) {
			em.merge(subject);
		}
	}

	@Override
	public void remove(Long id) {
		Subject subject = em.find(Subject.class, id);
		if (subject != null) {
			em.remove(subject);
		}
	}

}
