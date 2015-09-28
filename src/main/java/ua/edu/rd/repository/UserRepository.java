package ua.edu.rd.repository;

import java.util.List;

import ua.edu.rd.domain.Role;
import ua.edu.rd.domain.User;

public interface UserRepository {

	public void save(User user);

	public void update(User user);

	public User findByid(Long id);

	public List<User> getAllUsers();

	public List<User> getAllUsersByRole(Role role);

	public User getByEmailAndPassword(String email, String password);

	public User getByEmail(String email);

}
