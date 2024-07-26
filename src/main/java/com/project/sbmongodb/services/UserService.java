package com.project.sbmongodb.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbmongodb.domain.User;
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
}
