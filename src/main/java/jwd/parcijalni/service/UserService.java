package jwd.parcijalni.service;

import java.util.List;

import jwd.parcijalni.model.User;

public interface UserService {
	
	public List<User> findAll();
	public User findOne(Long id);
	public User save(User user);
	public List<User> save(List<User> user);
	public User delete(User user);
	public List<User> delete(List<User> users);
}
