package com.example.service;

import java.util.Map;

import com.example.entity.UserMaster;

public interface UserService {
	public Map<Integer,String>findCountries();
	public Map<Integer,String>findState(Integer CountryId);
	public Map<Integer,String>findCities(Integer StatedId);
	public boolean isEmailUnique(String emailId);
	public boolean saveUser(UserMaster um);
     //login page
    public String loginCheck(String email,String pwd);
    //Unlock account
    public boolean isTempPwdValid(String email,String tempPwd);
    public boolean unlockAccount(String email,String newpwd);
    //forget password
    public String forgetPassword(String email);
}
