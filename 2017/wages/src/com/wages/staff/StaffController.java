package com.wages.staff;

import com.jfinal.core.Controller;

public class StaffController extends Controller{
	StaffService service = new StaffService();
	public void index(){
		render("staff.html");
	}
	/**
	 * 查询员工信息
	 */
	public void queryStaff(){
		
		
	}
}
