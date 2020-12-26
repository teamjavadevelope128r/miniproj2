package com.example.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster,Serializable> {
	      UserMaster findByEmailId(String emailId);
	      UserMaster findByEmailIdAndPassword(String emailId, String password);
	      UserMaster findBuUserId(Integer uid);

}
