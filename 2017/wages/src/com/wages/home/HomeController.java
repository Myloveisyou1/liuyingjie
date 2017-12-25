package com.wages.home;



import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jfinal.core.Controller;
import com.jfinal.json.JFinalJson;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wages.base.Benefit;
import com.wages.base.GoodsList;
import com.wages.base.Message;
import com.wages.base.SecondCategory;
import com.wages.base.Shops;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class HomeController extends Controller{

	HomeService service = new HomeService();
	
	//private static final String URL = "/manji/uploads/circlemes/resource/benefit.xml";
	private static final String URL = "E:/benefit.xml";
	
	public void index(){


		renderText("Hello World");
	}
	
	/**
	 * 展示所有导航栏信息
	 */
	
	public void getNavagition() throws Exception{
		
		
		Message msg = new Message();
		
		String categoryStr = getPara("categoryStr");
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(URL));
		Element node = document.getRootElement();
		Element node1 = node.element("recommendList");
		List<Element> goodsId = node1.elements("goods");
		String category = "";
		for(int i=0;i<goodsId.size();i++) {
			
			if(categoryStr.equals(goodsList(goodsId.get(i)).getCategoryId()+"")){
				
				category += goodsList(goodsId.get(i)).getGoodId()+",";
				
			}
		}
		
		categoryStr = category.substring(0, category.length()-1);
		
		if(categoryStr == null) {
			
			msg.setStatus("3");
			msg.setMessage("请传入参数");
			
		}  else {
			
			String par = "("+categoryStr+")";
			
			List<Record> catData = service.benefit(par);
			
			msg.setStatus("1");
			msg.setMessage("请求成功");
			msg.setResult(catData);
	
		}
	
	String callback = getPara("callback");
	
	
	renderText(callback+"("+JFinalJson.getJson().toJson(msg).toString()+")");
		
	}
	
	
	/**
	 * 根据一级分类查询所有二级分类
	 */
	
	public void getSecCategory() throws Exception{
		
		
		Message msg = new Message();
		
		String categoryStr = getPara("categoryStr");
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(URL));
		Element node = document.getRootElement();
		Element node1 = node.element("categoryList");
		List<Element> categories = node1.elements("category");
		List<Element> secList;
		List<Object> obj = new ArrayList<Object>();
		String category = "";
		
		for(int i=0;i<categories.size();i++) {
			
			if(categoryStr.equals(categories.get(i).element("id").getTextTrim())){
				
				secList = categories.get(i).element("list").elements("secList");
				
				for (int j=0;j<secList.size();j++) {
					Map<String,Object> map = new HashMap<String,Object>();
					SecondCategory sc = secondList(secList.get(j));
					map.put("id",sc.getId());
					map.put("title", sc.getTitle());
					JSONObject object = JSONObject.fromObject(map);
					obj.add(object);
				}
				
				msg.setStatus("1");
				msg.setMessage("二级分类信息获取成功");
				msg.setResult(obj);
				
			}
		}
		
		String callback = getPara("callback");
		
		
		renderText(callback+"("+JFinalJson.getJson().toJson(msg).toString()+")");
		
		
	}
	
	/**
	 * 根据二级分类获取下面的所有商品信息
	 * @throws Exception
	 */
	public void getActivitiesInfo() throws Exception{
		
		
		Message msg = new Message();
		
		String categoryStr = getPara("categoryStr");
		Integer pageNum = getParaToInt("pageNum");
		
		if(pageNum == null) {
			pageNum = 1;
		}
		
		if(categoryStr == null) {
			
			msg.setStatus("3");
			msg.setMessage("请传入参数");
			
		}  else {
			
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(URL));
			Element node = document.getRootElement();
			Element node1 = node.element("goodsList");
			List<Benefit> listbean=new ArrayList<Benefit>();
			List<Element> li = node1.elements("goods");
			
			String category = "";
			for(int i=0;i<li.size();i++) {
				
				if(categoryStr.equals(goodsList(li.get(i)).getCategoryId()+"")){
					
					category += goodsList(li.get(i)).getGoodId()+",";
					
				}
			}
			categoryStr = category.substring(0, category.length()-1);
		
			String par = "("+categoryStr+")";
			
			Page<Record> catData = service.articleInfo(par,pageNum);
			
			msg.setStatus("1");
			msg.setMessage("请求成功");
			msg.setResult(catData);
	
		}
	
	String callback = getPara("callback");
	
	
	renderText(callback+"("+JFinalJson.getJson().toJson(msg).toString()+")");
		
	}
	
	
	/**
	 * 获取所有商品信息
	 * @param node
	 * @return
	 */
	 public GoodsList goodsList(Element node) { 
		 
		
		GoodsList goodsList = new GoodsList();
			
		goodsList.setGoodId(Integer.parseInt(node.elementTextTrim("goodId")));
		goodsList.setCategoryId(Integer.parseInt(node.elementTextTrim("categoryId")));
    	
    	return goodsList;
	    	
	    }
	 
	 /**
	  * 获取所有二级分类
	  * @param node
	  * @return
	  */
	 public SecondCategory secondList(Element node) { 
		 
			
		 SecondCategory secCategory = new SecondCategory();
		 
		 secCategory.setId(Integer.parseInt(node.element("id").getTextTrim()));
		 secCategory.setTitle(node.elementTextTrim("title"));
	    
    	 return secCategory;
		    	
	 }
	 
	
	////////////////////////////////////////////////////////
	
	
	/**
	 * 获取xml中的所有商品信息
	 * @throws Exception
	 */
	public void getGoodsInfo() throws Exception {
		
		Message msg = new Message();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(URL));
		Element node = document.getRootElement();
		Element node1 = node.element("goodsList");
		List<Element> li = new ArrayList<Element>();
		List<GoodsList> goodList=new ArrayList<GoodsList>();
		li = node1.elements("goods");
		
		for(int i=0;i<li.size();i++) {
			
			goodList.add(goodsList(li.get(i)));
		}

		String callback = getPara("callback");
		
		msg.setStatus("1");
		msg.setMessage("请求成功");
		msg.setResult(goodList);
		
		renderText(callback+"("+JFinalJson.getJson().toJson(msg).toString()+")");
		
	}
	
	
	/**
	 * 获取xml中的所有分类信息
	 * @throws Exception
	 */
	
	public void getCategoryInfo() throws Exception{
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(URL));
		Element node = document.getRootElement();
		Element node1 = node.element("categoryList");
		List<Element> li = new ArrayList<Element>();
		List<Benefit> listbean=new ArrayList<Benefit>();
		li = node1.elements("category");
		
		for(int i=0;i<li.size();i++) {
			
			listbean.add(categoryList(li.get(i)));
		}
		
		Message msg = new Message();
		msg.setStatus("1");
		msg.setMessage("请求成功");
		msg.setResult(listbean);
		
		String callback = getPara("callback");
		
		renderText(callback+"("+JFinalJson.getJson().toJson(msg).toString()+")");
		
	}
	
	/**
	 * 获取xml中的所有商家信息
	 * @throws Exception
	 */
	
	public void getShopInfo() throws Exception{
		
		Map<String,String> map = new HashMap<String,String>();
		String categoryId = getPara("categoryStr");
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(URL));
		
		Element node = document.getRootElement();
		Element node1 = node.element("shopList");
		List<Element> li = new ArrayList<Element>();
		List<Shops> shop=new ArrayList<Shops>();
		li = node1.elements("shop");
		
		for(int i=0;i<li.size();i++) {
			
			if("0".equals(categoryId)){
				
				shop.add(shopList(li.get(i)));
			} else if(li.get(i).element("categoryId").getText().equals(categoryId)){
				
				shop.add(shopList(li.get(i)));
			} 
		}
		
		Message msg = new Message();
		msg.setStatus("1");
		msg.setMessage("请求成功");
		msg.setResult(shop);

		String callback = getPara("callback");
		
		
		renderText(callback+"("+JFinalJson.getJson().toJson(msg).toString()+")");
	}
	
	
	 /**
	  * 获取所有分类信息
	  * @param node
	  * @return
	  */
	 public Benefit categoryList(Element node) { 
		 
		Benefit bene = new Benefit();
		
		bene.setId(Integer.parseInt(node.element("id").getText()));
		bene.setTitle(node.element("title").getText());
		
		
		return bene;
			
	}
   	
	
	 
	 /**
	  * 获取所有商家信息
	  * @param node
	  * @return
	  */
	 public Shops shopList(Element node) {
		 
		 Shops shop = new Shops();
		 
		 shop.setShopid(Integer.parseInt(node.element("shopId").getText()));
		 shop.setShopname(node.elementText("shopname"));
		 shop.setCategoryid(Integer.parseInt(node.element("categoryId").getText()));
		 
		 return shop;
	 }
	
}
