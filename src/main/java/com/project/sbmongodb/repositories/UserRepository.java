package com.project.sbmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.sbmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {

}
