package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.Role;
import ua.epam.rd.domain.User;

public interface UserService {

	public void save(User user);

	public void update(User user);

	public User findByid(Long id);

	public List<User> getAllUsers();

	public List<User> getAllUsersByRole(Role role);

	public User getByEmailAndPassword(String email, String password);

	public User getByEmail(String email);

}
