package com.project.sbmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.sbmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {

}
