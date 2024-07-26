package com.project.sbmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uservice;
	
	public List<User> findAll() {
		List<User> list = uservice.findAll();
		return list;
	}
	
}
