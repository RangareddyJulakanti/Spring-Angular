package jwd.parcijalni;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.model.User;
import jwd.parcijalni.service.ActivityService;
import jwd.parcijalni.service.UserService;

@Component
public class FillTable {
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void init(){
		activityService.save(new Activity("Swimming"));
		activityService.save(new Activity("Running"));
		activityService.save(new Activity("Jogging"));
		activityService.save(new Activity("Coding"));
		activityService.save(new Activity("Jumping"));
		
		userService.save(new User("Rade", "Spasojevic","crninovembar","radespasoje@gmail.com"));
		userService.save(new User("Ana", "Mitrovic","princeza","ana@gmail.com"));
		userService.save(new User("Cain", "Velasquez","fighter","hello@gmail.com"));
		userService.save(new User("Davide", "Beckam","football","hello2@gmail.com"));
	}

}
