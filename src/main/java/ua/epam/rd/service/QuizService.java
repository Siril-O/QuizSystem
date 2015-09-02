package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.Quiz;

public interface QuizService {

	public void save(Quiz quiz);

	public void update(Quiz quiz);

	public void remove(Long id);

	public Quiz findById(Long id);

	public List<Quiz> findAllQuizes();
}
