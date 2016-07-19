package jwd.parcijalni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.parcijalni.model.User;
import jwd.parcijalni.service.UserService;
import jwd.parcijalni.support.UserDtoToUser;
import jwd.parcijalni.support.UserRegistrationToUser;
import jwd.parcijalni.support.UserToUserDTO;
import jwd.parcijalni.web.dto.UserDTO;
import jwd.parcijalni.web.dto.UserRegistrationDTO;

@RestController
@RequestMapping("api/users")
public class ApiUserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private UserDtoToUser toUser;
	@Autowired
	private UserToUserDTO toDTO;
	@Autowired
	private UserRegistrationToUser toUserReg;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(@RequestParam(required=false, value="name") String name,
												 @RequestParam(required=true, value="page") int page){
		List<User> ret = null;
		int totalPages = 0;
		Long totalElements = 0l;
		HttpHeaders httpHeaders = new HttpHeaders();
		if(name!=null){
			Page<User> all = service.findByName(page, name);
			totalPages = all.getTotalPages();
			totalElements = all.getTotalElements();
			ret = all.getContent();
		}
		else{
			Page<User> all = service.findAll(page);
			totalPages = all.getTotalPages();
			totalElements = all.getTotalElements();
			ret = all.getContent();
		}

		httpHeaders.add("total-pages", "" + totalPages);
		httpHeaders.add("total-elements", "" + totalElements);
		return new ResponseEntity<>(toDTO.convert(ret), httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<UserDTO> findOne(@PathVariable Long id){
		User user = service.findOne(id);
		if(user == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(toDTO.convert(user), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<UserDTO> delete(@PathVariable Long id){
		User user = service.findOne(id);
		if(user == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		service.delete(user);
		
		return new ResponseEntity<>(toDTO.convert(user), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<UserDTO> save(@RequestBody UserRegistrationDTO dto){
		if(dto.getId()!=null || dto.getPassword()==null || dto.getPasswordConfirm()== null || !dto.getPassword().equals(dto.getPasswordConfirm())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User saved = service.save(toUserReg.convert(dto));
		
		return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);  
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO dto,@PathVariable Long id){
		
		if(dto.getId()!=id){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = service.save(toUser.convert(dto));
		return new ResponseEntity<>(toDTO.convert(user), HttpStatus.OK);
	}

}
