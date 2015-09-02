package ua.epam.rd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Variant;
import ua.epam.rd.repository.VariantRepository;

@Service
public class JPAVariantService implements VariantService {

	@Autowired
	private VariantRepository variantRepository;

	@Override
	@Transactional
	public void save(Variant variant) {
		variantRepository.save(variant);
	}

	@Override
	@Transactional
	public void updateVariant(Variant variant) {
		variantRepository.updateVariant(variant);
	}

	@Override
	public Variant findVariantById(Long id) {
		return variantRepository.findVariantById(id);
	}

	@Override
	public List<Variant> fiandAllVariants() {
		return variantRepository.fiandAllVariants();
	}

	@Override
	@Transactional
	public void remove(Long id) {
		variantRepository.remove(id);
	}

}
