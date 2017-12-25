package com.wages.login;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class LoginService {

	
	public List<Record> findUser(String userName,String password){
		
		return Db.use("wages").find("select * from t_user where password=? and user_name=?",password,userName);
		
	}
}
