package jwd.parcijalni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.parcijalni.model.User;

public interface UserService {
	
	public Page<User> findAll(int page);
	public User findOne(Long id);
	public User save(User user);
	public List<User> save(List<User> user);
	public User delete(User user);
	public List<User> delete(List<User> users);
	public Page<User> findByName(int page, String name);
}
