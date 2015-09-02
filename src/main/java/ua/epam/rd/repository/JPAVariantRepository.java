package ua.epam.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Variant;

@Repository
public class JPAVariantRepository implements VariantRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Variant variant) {
		em.persist(variant);
	}

	@Override
	public void updateVariant(Variant variant) {
		if (variant.getId() != null) {
			em.merge(variant);
		}
	}

	@Override
	public Variant findVariantById(Long id) {
		return em.find(Variant.class, id);
	}

	@Override
	public List<Variant> fiandAllVariants() {
		TypedQuery<Variant> query = em.createNamedQuery(
				"Variant.fiandAllVariants", Variant.class);
		return query.getResultList();
	}

	@Override
	public void remove(Long id) {
		Variant variant = em.find(Variant.class, id);
		if (variant != null) {
			variant.getQuestion().getVariants().remove(variant);
			em.remove(variant);
		}
	}

}
