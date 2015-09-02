package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.Subject;

public interface SubjectService {

	public void save(Subject subject);

	public void update(Subject subject);

	public void remove(Long id);

	public Subject findById(Long id);

	public List<Subject> getAllSubjects();
}
