package com.sumit.mongomodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
    private String id;

	@Indexed
	private String email;
	private String firstName;
	private String lastName;
    private String token;
    private String password;
	
	private List<Task> tasks;
    
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
