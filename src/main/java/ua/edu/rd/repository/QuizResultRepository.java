package ua.edu.rd.repository;

import java.util.List;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.QuizResult;
import ua.edu.rd.domain.User;

public interface QuizResultRepository {

	public void save(QuizResult quizResult);

	public QuizResult findById(Long id);

	public List<QuizResult> findByUser(User user);

	public List<QuizResult> findByQuiz(Quiz quiz);

	public void remove(Long id);
}
