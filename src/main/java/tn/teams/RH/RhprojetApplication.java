package tn.teams.RH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Lazy;

import tn.teams.RH.services.UserService;



@SpringBootApplication 
public class RhprojetApplication extends SpringBootServletInitializer implements CommandLineRunner{
	@Autowired
	@Lazy
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(RhprojetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userService.createadmine();
	}

}
