package com.project.sbmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.repositories.UserRepository;

@Configuration
public class Test implements CommandLineRunner {

	@Autowired
	private UserRepository urepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		urepo.deleteAll();
		
		User user1 = new User(null, "Junior", "junior@gmail.com");
		User user2 = new User(null, "João", "joão@gmail.com");
		User user3 = new User(null, "Marcos", "marcos@gmail.com");
		urepo.saveAll(Arrays.asList(user1, user2, user3));
		
	}

}
