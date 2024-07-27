package com.project.sbmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO obj) {
		User user = uservice.fromDTO(obj);
		user = uservice.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		uservice.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
