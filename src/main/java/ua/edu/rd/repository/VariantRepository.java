package ua.edu.rd.repository;

import java.util.List;

import ua.edu.rd.domain.Variant;

public interface VariantRepository {

	public void save(Variant variant);

	public void updateVariant(Variant variant);
	
	public Variant findVariantById(Long id);

	public List<Variant> fiandAllVariants();

	void remove(Long id);
}
