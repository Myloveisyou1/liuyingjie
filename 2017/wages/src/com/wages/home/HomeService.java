package com.wages.home;


import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;



public class HomeService {
	
	HomeRepository service = new HomeRepository();
	
	/**
	 * 导航信息
	 */
	
	public List<Record> benefit(String par){
		
		StringBuffer sql = new StringBuffer("select article_id,article_title,article_img_url,article_order_times,article_sell_price from dt_article_screen where article_id in " + par);
				
		List<Record> page = Db.find(sql.toString());
		
		return page;
		
		
	}
	
	/**
	 * 展示所有商品信息
	 * @return
	 */
	public Page<Record> articleInfo(String par,int pageNum){
		
		String sql = " from dt_article_screen where article_id in "+ par;
		
		Page<Record> page = service.articleInfo(pageNum, sql);
		
		return page;
	}
	
/*	public Page<Record> findBusiness(String name,int pageNum){
		String sql = "from dt_article_category c,dt_users u,dt_user_role_shopinfo s where u.id = s.user_id and s.main_business = c.id and s.name like '%"+name+"%'";
		Page<Record> page = orderRepository.findShopInfo(sql,pageNum);
		return page;
	}*/
/*	public List<Record> benefit(String par,int pageNum,String keyWords){
		
		StringBuffer sql = new StringBuffer(" WITH a AS ( SELECT * FROM dt_article_category WHERE id in  "+par+
				
				" UNION ALL SELECT s.* FROM dt_article_category AS s,a WHERE s.parent_id=a.id ) "+
				
				" SELECT article_id,article_title,article_img_url,shop_send_area,article_order_times,article_sell_price FROM "+
				
			    " ( SELECT row_number() over (order by tempcolumn) temprownumber, * FROM "+
			    
				" (select top "+pageNum*5+" tempcolumn=0,* from dt_article_screen where article_category_id in "+
				
				" (select id from a where class_layer =  (SELECT top 1 class_layer FROM a order by class_layer desc) ) "
				
				);
		
		
		if(keyWords !=null && !"".equals(keyWords)) {
			
			sql.append(" and article_title like '%"+keyWords+"%'");
		}
		
		sql.append(" order by id desc  )vip)mvp where temprownumber> "+(pageNum-1)*5);
		
		List<Record> records = Db.find(sql.toString());
		
		return records;
		
		
	}
*/	
	/**
	 * 查询总页数
	 * @param pageNum
	 * @param keyWords
	 * @return
	 */
	/*public int pageTotal(String par,String keyWords){
		
		StringBuffer sb = new StringBuffer("  WITH a AS ( SELECT * FROM dt_article_category WHERE id in   "+par+
				
				" UNION ALL SELECT s.* FROM dt_article_category AS s,a WHERE s.parent_id=a.id ) "+ 
				
				" select count(*) as pageTotal from dt_article_screen where article_category_id in "+
				
				" (select id from a where class_layer =  (SELECT top 1 class_layer FROM a order by class_layer desc) )  ");
		
		if(keyWords != null && !"".equals(keyWords)) {
			
			sb.append(" and article_title like '%"+keyWords+"%'");
			
		}
		
		int pageTotal = Db.queryInt(sb.toString());
		
		return pageTotal;
	}*/
	
	/**
	 * 获取城市
	 * @param code
	 * @return
	 */
	public String getCity(String code) {
		
		String sql = "select name from dt_apo_city where code=?";
		
		String city = Db.queryStr(sql,code);
		
		return city;
	}
	
	
	
	
	
}
