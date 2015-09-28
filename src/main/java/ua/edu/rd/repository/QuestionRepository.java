package ua.edu.rd.repository;

import java.util.List;

import ua.edu.rd.domain.Question;

public interface QuestionRepository {

	public void save(Question question);
	
	public void update(Question question);
	
	public void remove(Long id);
	
	public Question findById(Long id);
	
	public List<Question> findAllQuestions();
	
}
