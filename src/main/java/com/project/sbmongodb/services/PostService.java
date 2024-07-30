package com.project.sbmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbmongodb.domain.Post;
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
	
	public List<Post> findByTitle(String text) {
		return post.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return post.fullSearch(text, minDate, maxDate);
	}
}
