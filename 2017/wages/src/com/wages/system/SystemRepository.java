package com.wages.system;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class SystemRepository {
	
	public Page<Record> findUser(int pageNumber,int pageSize,String sql){
		
		return Db.use("wages").paginate(pageNumber, pageSize, "select *", sql);
		
	}
}
