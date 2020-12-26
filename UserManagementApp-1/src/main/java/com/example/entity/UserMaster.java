package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserMaster {
	@GeneratedValue
	@Id
	private Integer Id;
	private String Fname;
	private String Lname;
	private String Email;
	private Long   Phoneno;
	private String password;
	private String Dob;
	private String Gender;
	private String Country;
	private String State;
	private String City;
	private String status; 
	

}
