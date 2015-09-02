package ua.epam.rd.repository;

import java.util.List;

import ua.epam.rd.domain.Quiz;

public interface QuizRepository {

	public void save(Quiz quiz);

	public void update(Quiz quiz);

	public void remove(Long id);

	public Quiz findById(Long id);

	public List<Quiz> findAllQuizes();
}
