package jwd.parcijalni.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.parcijalni.model.User;
import jwd.parcijalni.repository.UserRepository;
import jwd.parcijalni.service.UserService;

@Service
public class JpaUserService implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> save(List<User> user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User delete(User us) {
		
		User user = userRepository.findOne(us.getId());
		if(!user.equals(us)){
			return null;
		}
		
		userRepository.delete(us.getId());
		
		return user;
	}

	@Override
	public List<User> delete(List<User> users) {
		List<User> ret = new ArrayList<>();
		for(User user: users){
			ret.add(delete(user));
		}
		return ret;
	}

}
