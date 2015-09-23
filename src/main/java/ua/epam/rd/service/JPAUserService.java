package ua.epam.rd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Role;
import ua.epam.rd.domain.User;
import ua.epam.rd.repository.UserRepository;

@Service
public class JPAUserService implements UserService {

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
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public List<User> getAllUsersByRole(Role role) {
		return userRepository.getAllUsersByRole(role);
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

}
