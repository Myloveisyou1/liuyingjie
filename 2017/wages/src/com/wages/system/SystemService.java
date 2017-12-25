package com.wages.system;

import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class SystemService {

	private SystemRepository systemR = new SystemRepository();
	/**
	 * 查询账户信息
	 * @param userName   账户名称
	 * @param pageNumber 查询的页码
	 * @param pageSize   每页条数
	 * @return
	 */
	public Page<Record> findUser(String userName,int pageNumber,int pageSize){
		String sql = "";
		if("".equals(userName)){
			sql = "from t_user where 1=1";
		}else{
			sql = "from t_user where user_name='"+userName+"'";
		}
		return systemR.findUser(pageNumber,pageSize,sql);
	}
}
