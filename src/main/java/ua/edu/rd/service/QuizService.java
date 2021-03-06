package ua.edu.rd.service;

import java.util.List;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Subject;

public interface QuizService {

	public void save(Quiz quiz);

	public void update(Quiz quiz);

	public void remove(Long id);

	public Quiz findById(Long id);
	
	public List<Quiz> findQuizesBySubject(Subject subject);

	public List<Quiz> findAllQuizes();
}
