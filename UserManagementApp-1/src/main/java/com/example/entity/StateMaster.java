package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StateMaster {
	@GeneratedValue
	@Id
	private Integer StateId;
	private String  StateName;
	private Integer CountryId;

}
