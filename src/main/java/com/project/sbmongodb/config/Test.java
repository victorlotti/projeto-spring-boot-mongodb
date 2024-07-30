package com.project.sbmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.sbmongodb.domain.Post;
import com.project.sbmongodb.domain.User;
import com.project.sbmongodb.dto.AuthorDTO;
import com.project.sbmongodb.dto.CommentDTO;
import com.project.sbmongodb.repositories.PostRepository;
import com.project.sbmongodb.repositories.UserRepository;

@Configuration
public class Test implements CommandLineRunner {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private PostRepository post;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		post.deleteAll();
		urepo.deleteAll();
		
		User user1 = new User(null, "Junior", "junior@gmail.com");
		User user2 = new User(null, "João", "joão@gmail.com");
		User user3 = new User(null, "Marcos", "marcos@gmail.com");
		urepo.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, sdf.parse("21/06/2000"), "Partiu viagem", "Vou viajar para São Paulo. Abracos!", new AuthorDTO(user1));
		Post post2 = new Post(null, sdf.parse("24/07/2000"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/06/2000"), new AuthorDTO(user3));
		CommentDTO comment2 = new CommentDTO("Aproveite a viagem", sdf.parse("21/06/2000"), new AuthorDTO(user2));
		CommentDTO comment3 = new CommentDTO("Tenha um bom dia!!", sdf.parse("24/07/2000"), new AuthorDTO(user3));
		
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		post.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1, post2));
		urepo.save(user1);
		
	}

}
