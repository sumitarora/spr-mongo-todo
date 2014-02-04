package com.sumit.mongorepository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sumit.mongomodel.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    
}
