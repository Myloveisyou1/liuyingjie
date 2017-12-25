package controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;

import model.Menu;
import model.MenuInfo;
import thread.TestThread;

public class TestController extends Controller{

	
	public void breakCode(){
		
		TestThread t = new TestThread();
		t.run();
		renderText("成功");
	}
	
	public void test(){
		
		MenuInfo mi = new MenuInfo();
		List<Menu> list = new ArrayList<Menu>();
			Menu child = new Menu();
			child.setMenu_id("02");
			child.setMenu_name("老大的儿子");
			child.setCode("02_01");
			child.setSort("02");
			list.add(child);
		mi.setMenu_id("01");
		mi.setMenu_name("老大");
		mi.setCode("01");
		mi.setSort("1");
		mi.setChild(list);
		
		renderJson(mi);
	}
}
