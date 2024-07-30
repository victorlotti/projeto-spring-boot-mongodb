package com.project.sbmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.sbmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {

	List<Post> findByTitleContaining(String text);
	
}
