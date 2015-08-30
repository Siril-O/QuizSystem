package ua.epam.rd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Subject;
import ua.epam.rd.repository.SubjectRepository;

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

}