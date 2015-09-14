package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.QuizResult;
import ua.epam.rd.domain.User;

public interface QuizResultService {

	public void save(QuizResult quizResult);

	public QuizResult findById(Long id);

	public List<QuizResult> findByUser(User user);
}
