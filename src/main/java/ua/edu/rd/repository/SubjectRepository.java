package ua.edu.rd.repository;

import java.util.List;

import ua.edu.rd.domain.Subject;

public interface SubjectRepository {

	public void save(Subject subject);

	public void update(Subject subject);

	public void remove(Long id);

	public Subject findById(Long id);

	public List<Subject> getAllSubjects();
}
