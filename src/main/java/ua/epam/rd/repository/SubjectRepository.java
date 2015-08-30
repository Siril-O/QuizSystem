package ua.epam.rd.repository;

import java.util.List;

import ua.epam.rd.domain.Subject;

public interface SubjectRepository {

	public void save(Subject subject);
	
	public List<Subject> getAllSubjects();
}
