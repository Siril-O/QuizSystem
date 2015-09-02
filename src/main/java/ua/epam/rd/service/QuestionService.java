package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.Question;

public interface QuestionService {

	public void save(Question question);

	public void update(Question question);
	
	public void remove(Long id);

	public Question findById(Long id);

	public List<Question> findAllQuestions();

}
