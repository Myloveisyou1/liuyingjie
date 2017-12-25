package controller;

import java.io.UnsupportedEncodingException;

import com.jfinal.core.Controller;

import utils.DecriptUtil;
import utils.MD5util;
/**
 * 各种加密解密
 * @author Administrator
 *
 */
public class CryptoUtilsController extends Controller{
	
	public void toMd5(){
		render("md5.html");
	}
	public void toSha(){
		render("sha.html");
	}
	public void toBase64(){
		render("base64.html");
	}
	/**
	 * MD5加密
	 */
	public void md5(){
		String code = getPara("code");
		String result = MD5util.getMD5(code).substring(8, 24).toLowerCase()+";"+MD5util.getMD5(code).substring(8, 24)+";"+MD5util.getMD5(code).toLowerCase()+";"+MD5util.getMD5(code);
		setAttr("result", result);
		setAttr("type", "md5");
		renderJson();
	}
	/**
	 * SHA-1加密
	 */
	public void sha(){
		String code = getPara("code");
		String type = getPara("type");
		String result = DecriptUtil.SHA(code,type)+";"+DecriptUtil.SHA(code,type).toUpperCase();
		setAttr("result", result);
		setAttr("type", "sha");
		renderJson();
	}
	/**
	 * Base64加密
	 * @throws UnsupportedEncodingException 
	 */
	public void base64() throws UnsupportedEncodingException{
		String code = getPara("code");
		String type = getPara("type");
		String result = "";
		if(type.equals("outside")){//解密
			result = DecriptUtil.decode(code);
		}else{
			result = DecriptUtil.encode(code.getBytes());
		}
		setAttr("result", result);
		setAttr("type", "base64");
		renderJson();
	}
}
