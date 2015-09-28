package ua.edu.rd.service;

import java.util.List;

import ua.edu.rd.domain.QuizResult;
import ua.edu.rd.domain.User;

public interface QuizResultService {

	public void save(QuizResult quizResult);

	public QuizResult findById(Long id);

	public List<QuizResult> findByUser(User user);
}
