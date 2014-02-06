package com.sumit.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sumit.mongomodel.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
	
	//public User findByFirstName(String firstName);
    //public List<User> findByLastName(String lastName);
    
}
