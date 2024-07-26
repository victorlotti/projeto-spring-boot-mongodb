package com.project.sbmongodb.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.dto.UserDTO;
import com.project.sbmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired	
    private UserService uservice;
    
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = uservice.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User u = uservice.findById(id);
		return ResponseEntity.ok().body(new UserDTO(u));
	}
	
}
