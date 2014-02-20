package com.sumit.mongorepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.Mongo;
import com.sumit.mongomodel.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public List<User> findByEmail(String email);
//	/public User findByEmailPassword(String email, String password);
	
    
}
