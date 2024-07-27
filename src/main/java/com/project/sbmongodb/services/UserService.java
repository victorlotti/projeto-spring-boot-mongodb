package com.project.sbmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.dto.UserDTO;
import com.project.sbmongodb.repositories.UserRepository;
import com.project.sbmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository uservice;
	
	public List<User> findAll() {
		List<User> list = uservice.findAll();
		return list;
	}
	
	public User findById(String id) {
		Optional<User> user = uservice.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return uservice.insert(obj);
	}
	
	public User fromDTO(UserDTO objDT) {
		return new User(objDT.getId(), objDT.getName(), objDT.getEmail());
	}
	
	public User update(User obj) {
		Optional<User> update = uservice.findById(obj.getId());
		User u = update.get();
		updateDate(u, obj);
		return uservice.save(u);
	}
	
	private void updateDate(User oldUser, User obj) {
		oldUser.setName(obj.getName());
		oldUser.setEmail(obj.getEmail());
	}

	public void delete(String id) {
		findById(id);
		uservice.deleteById(id);
	}
}
