package com.love.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2017/12/19 0019 10:34
 */
public class CrawlerUtils {

    public String getHtml(String path) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        URL url = new URL(path);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
        InputStream is=connection.getInputStream();
         //一般按行读取网页数据，并进行内容分析
         //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
         //进行转换时，需要处理编码格式问题
        BufferedReader br=new BufferedReader(new InputStreamReader(is,"gb2312"));
         //按行读取并打印
         String line=null;
        String regex="<p.*?>(.*?)</p> ";
        Pattern p =Pattern.compile(regex);
         while((line=br.readLine())!=null){
             new ForFile().createFile(fileName,line);
             System.out.println(line);
         }
         br.close();

        return fileName;

    }
}
