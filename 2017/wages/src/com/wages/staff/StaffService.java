package com.wages.staff;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class StaffService {

	StaffRepository reposiyory = new StaffRepository();
	
	public List<Record> queryStaff(){
		
		return Db.use("wages").find("select * from t_staff where 1=1");
	}
} 
