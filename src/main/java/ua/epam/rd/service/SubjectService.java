package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.Subject;

public interface SubjectService {

	public void save(Subject subject);

	public List<Subject> getAllSubjects();
}
