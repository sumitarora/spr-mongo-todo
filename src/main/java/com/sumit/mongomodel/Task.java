package com.sumit.mongomodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

import com.sumit.enums.Priority;
import com.sumit.enums.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
    private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "due_date")
	private Date dueDate;

	private String name;

	private Priority priority;

	private Status status;	
}
