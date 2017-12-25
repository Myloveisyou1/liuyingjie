package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;

import model.DateCode;
import utils.JsonUtils;

public class DateFormatController extends Controller{

	DateCode code = new DateCode();
	
	public void index(){
		render("time.html");
	}
	/**
	 * 获取想要变换的时间的毫秒数
	 */
	public void getTimestamp(){
		
		Date date = getParaToDate("startTime");
		if(date == null){
			date = new Date();
		}
		renderText("所选时间的毫秒数:"+date.getTime()+"");
	}
	/**
	 * 获取每个月的最后一天
	 * @throws ParseException 
	 */
	public void getLastDay() throws ParseException{
		
		Date date = getParaToDate("startTime");//2017-07
		String d = code.format_m.format(date);
		int m = Integer.parseInt(d.split("-")[1]);
		date = new Date(code.format_d.parse(d.split("-")[0]+"-"+(m+1)+"-01").getTime()-24*60*60*1000);
		renderText("所选月份的最后一天是："+code.format_d.format(date));
	}
	/**
	 * 获取两个日期间的天数
	 */
	public void getDays(){
		
		Date start = getParaToDate("startTime");
		Date end = getParaToDate("endTime");
		if(end == null){
			end = new Date();
		}
		long d = (end.getTime() - start.getTime())/(24*60*60*1000);
		setAttr("result", d);
		setAttr("type", "getDays");
		renderJson();
	}
	/**
	 * 获取所选时间x天后的时间
	 */
	public void getDate(){
		Date start = getParaToDate("startTime");
		int day = getParaToInt("days");
		String type = getPara("type");
		String date = "";
		Long l = (long) day*24*60*60*1000;
		if(type.equals("forward")){
			date = code.format_d.format(new Date(start.getTime()-l));
		}else{
			date = code.format_d.format(new Date(start.getTime()+l));
		}
		setAttr("result", date);
		setAttr("type", "getDate");
		renderJson();
	}
	/**
	 * 解析json
	 */
	public void toJson(){
		String str = getPara("str");
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("name", "哈哈哈");
//		map.put("password", "123456");
//		map.put("code", "000000");
		System.out.println(JsonUtils.json(str));
		renderText(JsonUtils.json(str));
	}
}
