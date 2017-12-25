package com.wages.base;


import com.jfinal.config.Routes;
import com.wages.home.HomeController;


public class _RouteKit {

	public static Routes routing(Routes route) {
		
		route.add("/",HomeController.class,"/WEB-INF/html/index");
		return route;
		
		
	}


}
