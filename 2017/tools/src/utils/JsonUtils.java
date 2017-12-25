package utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtils {

	public static String json(Object obj){
		
		return JSONObject.fromObject(obj).toString();
	}
	
	public static String array(Object obj){
		return JSONArray.fromObject(obj).toString();
		
	}
	public static void main(String[] args){
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "哈哈哈");
		map.put("password", "123456");
		map.put("code", "000000");
		System.out.println(JsonUtils.json(map));
	}
}
