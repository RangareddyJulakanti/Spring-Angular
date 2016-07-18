package jwd.parcijalni.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method=RequestMethod.GET)
	public String toIndex(){
		return "static/app/html/index.html";
	}
}
