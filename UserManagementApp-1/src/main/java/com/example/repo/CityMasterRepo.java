package com.example.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CityMaster;

public interface CityMasterRepo extends JpaRepository<CityMaster, Serializable> {
    List<CityMaster>findByStateId(Integer StateId);
}
