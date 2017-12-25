package com.wages.home;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class HomeRepository {
	
	
public Page<Record> articleInfo(int pageNumber,String sql){
		
		return Db.paginate(pageNumber, 8, "select article_id,article_title,article_img_url,article_order_times,article_sell_price ", sql);
		
	}

}
