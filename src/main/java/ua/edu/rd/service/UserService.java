package ua.edu.rd.service;

import java.util.List;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Role;
import ua.edu.rd.domain.User;

public interface UserService {

	public void save(User user);

	public void update(User user);

	public User findByid(Long id);

	public List<User> getAllUsers(Integer offset, Integer maxResults);

	public Long getAllUsersTotalResulCount();

	public Long getAllUsersPagesNumber(Integer maxResults);

	public List<User> getAllUsersByRole(Role role, Integer offset,
			Integer maxResults);

	public Long getAllUsersByRoleTotalResulCount(Role role);

	public Long getAllUsersByRolePagesNumber(Role role, Integer maxResults);

	public User getByEmailAndPassword(String email, String password);

	public User getByEmail(String email);

	public List<User> getUsersAssignedToQuiz(Quiz quiz);

}
