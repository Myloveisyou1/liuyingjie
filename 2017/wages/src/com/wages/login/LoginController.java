package com.wages.login;

import java.util.List;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
@Clear
public class LoginController extends Controller{
	
	private LoginService service = new LoginService();
	
	public void index(){
		render("login.html");
	}
	
	public void login(){
		
		String userName = getPara("userName");
		String password = getPara("password");
		
		List<Record> list = service.findUser(userName, password);
		if(list != null && list.size() == 1){
			//记录session信息
			setSessionAttr("user", list.get(0));
			//记录日志信息
			setAttr("message", "SUCCESS");
			redirect("/home/index");
			
		}else{
			setAttr("message", "ERROR");
			render("login.html");
		}
		
	}

}
