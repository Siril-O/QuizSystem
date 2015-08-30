package ua.epam.rd.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Quiz;
import ua.epam.rd.repository.QuizRepository;

@Service
public class JPAQuizService implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	@Transactional
	public void save(Quiz quiz) {

		quizRepository.save(quiz);
	}

}
