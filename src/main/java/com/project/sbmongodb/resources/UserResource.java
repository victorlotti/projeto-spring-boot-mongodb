package com.project.sbmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired	
    private UserService uservice;
    
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = uservice.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
