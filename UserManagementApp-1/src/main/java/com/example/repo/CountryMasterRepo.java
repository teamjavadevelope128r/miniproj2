package com.example.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CountryMaster;

public interface CountryMasterRepo extends JpaRepository<CountryMaster,Serializable> {
                 
}
