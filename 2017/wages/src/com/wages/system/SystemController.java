package com.wages.system;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class SystemController extends Controller {
	
	private SystemService service = new SystemService();
	
	//*****************************************************************
	/**进入模块显示的页面*/
	public void index(){
		render("user.html");
	}
	/**账户管理显示的页面*/
	public void toUser(){
		setAttr("userInfo", service.findUser("",1,10));
		render("user.html");
	}
	/**员工管理显示的页面*/
	public void toStaff(){
		render("staff.html");
	}
	/**权限管理显示的页面*/
	public void toJurisdiction(){
		render("jurisdiction.html");
	}
	/**日志管理显示的页面*/
	public void toLogs(){
		render("log.html");
	}
	//*****************************************************************
	/**
	 * 查询账户信息
	 */
	public void findUser(){
		String userName = getPara("user_name");
		int pageNumber = getParaToInt("pageNumber");
		int pageSize = getParaToInt("pageSize");
		if("".equals(pageNumber+"")){
			pageNumber = 1;
		}
		if("".equals(pageSize+"")){
			pageSize = 10;
		}
		Page<Record> list = service.findUser(userName,pageNumber,pageSize);
		setAttr("userInfo",list);
		render("user.html");
	}
}
