package com.example.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StateMaster;

public interface StateMasterRepo extends JpaRepository<StateMaster, Serializable> {
     List<StateMaster>findByCountryId(Integer CountryId);
}
