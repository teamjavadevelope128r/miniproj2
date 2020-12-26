package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CountryMaster {
	@GeneratedValue
	@Id
	private Integer CountryId;
	private String  CountryName;
	

}
