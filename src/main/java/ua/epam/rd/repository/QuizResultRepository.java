package ua.epam.rd.repository;

import java.util.List;

import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.User;

public interface QuizResultRepository {

	public void save(QuizResult quizResult);

	public QuizResult findById(Long id);

	public List<QuizResult> findByUser(User user);

}
