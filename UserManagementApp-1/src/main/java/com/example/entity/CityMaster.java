package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CityMaster {
	@GeneratedValue
	@Id
	private Integer CityId;
	private String  CityName;
	private Integer StateId;

}
