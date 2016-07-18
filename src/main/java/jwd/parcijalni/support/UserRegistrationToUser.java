package jwd.parcijalni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.User;
import jwd.parcijalni.service.UserService;
import jwd.parcijalni.web.dto.UserDTO;
import jwd.parcijalni.web.dto.UserRegistrationDTO;

@Component
public class UserRegistrationToUser implements Converter<UserRegistrationDTO, User> {

	@Autowired
	private UserService userService;
	
	@Override
	public User convert(UserRegistrationDTO dto) {
		
		User user = null;
		
		if(dto.getId()==null){
			user = new User();
		}
		else{
			user = userService.findOne(dto.getId());
			if(user == null){
				throw new IllegalStateException("Edditing - non existing User.");
			}
		}
		
		user.setEmail(dto.getEmail());
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		
		return user;
		
	}

	public List<User> convert(List<UserRegistrationDTO> dtos){
		List<User> ret = new ArrayList<>();
		
		for(UserRegistrationDTO dto: dtos){
			ret.add(convert(dto));
		}
		
		return ret;
	}
}
