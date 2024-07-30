package com.project.sbmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbmongodb.domain.Post;
import com.project.sbmongodb.resources.util.URL;
import com.project.sbmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postservice;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postservice.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	
	/* @RequestParam (?) serve para fazer uma 
	 * requisição de um parametro informado
	 * (/titlesearch?text=textoiformado)
	 * 
	 */
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeURL(text);
		List<Post> list = postservice.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
