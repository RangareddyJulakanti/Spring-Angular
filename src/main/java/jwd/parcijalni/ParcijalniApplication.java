package jwd.parcijalni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jwd.parcijalni.web.controller.IndexController;

@SpringBootApplication
public class ParcijalniApplication {
	
	@Autowired
	private FillTable fillTable;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ParcijalniApplication.class, args);
	}

}
