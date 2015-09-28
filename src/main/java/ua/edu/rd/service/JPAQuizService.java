package ua.edu.rd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Subject;
import ua.edu.rd.repository.QuizRepository;

@Service
public class JPAQuizService implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	@Transactional
	public void save(Quiz quiz) {
		quizRepository.save(quiz);
	}

	@Override
	@Transactional
	public void update(Quiz quiz) {
		quizRepository.update(quiz);
	}

	@Override
	public Quiz findById(Long id) {
		return quizRepository.findById(id);
	}

	@Override
	public List<Quiz> findAllQuizes() {
		return quizRepository.findAllQuizes();
	}

	@Override
	@Transactional
	public void remove(Long id) {
		quizRepository.remove(id);
	}

	@Override
	public List<Quiz> findQuizesBySubject(Subject subject) {
		return quizRepository.findQuizesBySubject(subject);
	}

}
