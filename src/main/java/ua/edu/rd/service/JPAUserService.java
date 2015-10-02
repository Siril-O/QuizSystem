package ua.edu.rd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Role;
import ua.edu.rd.domain.User;
import ua.edu.rd.repository.UserRepository;

@Service
public class JPAUserService implements UserService {

	private static final int DEFAULT_MAX_RESULT = 5;
	private static final int DEFAULT_OFFSET = 0;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public User findByid(Long id) {
		return userRepository.findByid(id);
	}

	@Override
	public List<User> getAllUsersByRole(Role role, Integer offset,
			Integer maxResults) {
		return userRepository.getAllUsersByRole(role, offset != null ? offset
				: DEFAULT_OFFSET, maxResults != null ? maxResults
				: DEFAULT_MAX_RESULT);
	}

	@Override
	public Long getAllUsersByRoleTotalResulCount(Role role) {
		return userRepository.getAllUsersByRoleTotalResulCount(role);
	}

	@Override
	public Long getAllUsersByRolePagesNumber(Role role, Integer maxResults) {
		if (maxResults == null) {
			maxResults = DEFAULT_MAX_RESULT;
		}
		long totalResults = userRepository
				.getAllUsersByRoleTotalResulCount(role);
		long pagesNumber = totalResults / maxResults;
		return (totalResults % maxResults) != 0 ? pagesNumber + 1 : pagesNumber;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userRepository.getByEmailAndPassword(email, password);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}

	@Override
	@Transactional
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public List<User> getUsersAssignedToQuiz(Quiz quiz) {
		return userRepository.getUsersAssignedToQuiz(quiz);
	}

	@Override
	public List<User> getAllUsers(Integer offset, Integer maxResults) {

		return userRepository.getAllUsers(offset != null ? offset
				: DEFAULT_OFFSET, maxResults != null ? maxResults
				: DEFAULT_MAX_RESULT);
	}

	@Override
	public Long getAllUsersTotalResulCount() {
		return userRepository.getAllUsersTotalResulCount();
	}

	@Override
	public Long getAllUsersPagesNumber(Integer maxResults) {
		if (maxResults == null) {
			maxResults = DEFAULT_MAX_RESULT;
		}
		long totalResults = userRepository.getAllUsersTotalResulCount();
		long pagesNumber = totalResults / maxResults;
		return (totalResults % maxResults) != 0 ? pagesNumber + 1 : pagesNumber;
	}

}
