package com.project.sbmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbmongodb.domain.Post;
import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.repositories.PostRepository;
import com.project.sbmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	
	@Autowired
	private PostRepository post;
	
	public Post findById(String id) {
		Optional<Post> p = post.findById(id);
		return p.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
}
