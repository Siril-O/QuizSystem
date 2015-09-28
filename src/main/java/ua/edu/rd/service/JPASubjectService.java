package ua.edu.rd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.rd.domain.Subject;
import ua.edu.rd.repository.SubjectRepository;

@Service
public class JPASubjectService implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	@Transactional
	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.getAllSubjects();
	}

	@Override
	public Subject findById(Long id) {
		return subjectRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Subject subject) {
		subjectRepository.update(subject);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		subjectRepository.remove(id);
	}

}
