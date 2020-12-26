package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CityMaster;
import com.example.entity.CountryMaster;
import com.example.entity.StateMaster;
import com.example.entity.UserMaster;
import com.example.repo.CityMasterRepo;
import com.example.repo.CountryMasterRepo;
import com.example.repo.StateMasterRepo;
import com.example.repo.UserMasterRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMasterRepo umr;
	@Autowired
	private StateMasterRepo smr;
	@Autowired
	private CityMasterRepo cmr;
	@Autowired
	private CountryMasterRepo cmrp;

	@Override
	public Map<Integer, String> findCountries() {
		List<CountryMaster>countrymaster=cmrp.findAll();
		Map<Integer,String>countrymastermap=new HashMap<>();
		countrymaster.forEach(country->{
			countrymastermap.put(country.getCountryId(), country.getCountryName());
		});
		return countrymastermap;
	}


	@Override
	public Map<Integer, String> findState(Integer CountryId) {
            Map<Integer,String>states=new HashMap<>();
            List<StateMaster>statelist=smr.findByCountryId(CountryId);
            statelist.forEach(state->{
            	states.put(state.getStateId(),state.getStateName());
            });
		   return states;
		}
		


	@Override
	public Map<Integer, String> findCities(Integer StatedId) {
		Map<Integer,String>cities=new HashMap<>();
		List<CityMaster>citiesList=cmr.findByStateId(StatedId);
		    citiesList.forEach(city->{
		               cities.put(city.getCityId(), city.getCityName());  
		    });
		    return cities;
		}
	
	@Override
	public boolean isEmailUnique(String emailId) { 
		UserMaster userdetails=umr.findByEmailId(emailId);
		
		return userdetails.getId()==null;
	}

	@Override
	public boolean saveUser(UserMaster um) {
	    um.setPassword(passwordGenerator());
	    um.setStatus("Locked");
	    UserMaster saveObj=umr.save(um);
		return saveObj.getId()!=null;
	}
	
	private String passwordGenerator() {
		char[] password=new char[5];
		String alphanumeric="ABCaf12";
		Random randomPwd=new Random();
		for(int i=0;i<5;i++) {
		    password[i]=alphanumeric.charAt(randomPwd.nextInt(alphanumeric.length()));
		   
		}
		System.out.println(password.toString());
		return password.toString();
	}

	@Override
	public String loginCheck(String email, String pwd) {
		UserMaster user=umr.findByEmailIdAndPassword(email,pwd);
		if(user!=null) {
			if(user.getStatus().equals("Locked")) {
				return "Account Locked";
			}else {
				return "Login Sucess";
			}
			
		}
		return "Invalid Crediantials";
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		UserMaster user=umr.findByEmailIdAndPassword(email, tempPwd);
		return user.getId()!=null;
	}

	@Override
	public boolean unlockAccount(String email, String newpwd) {
		UserMaster user=umr.findByEmailId(email);
		user.setPassword(newpwd);
		user.setStatus("Unlocked");
		try {
			umr.save(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String forgetPassword(String email) {
		UserMaster user=umr.findByEmailId(email);
		if(user!=null) {
			return user.getPassword();
		}
		return null;
	}

}
