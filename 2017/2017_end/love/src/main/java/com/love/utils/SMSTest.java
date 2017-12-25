package com.love.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2017/12/20 0020 14:11
 */
public class SMSTest {


        private static final String addr = "http://api.sms.cn/sms/";
        private static final String userId = "six9";

        /*
        * 如uid是：test，登录密码是：123123
        pwd=md5(123123test),即
        pwd=b9887c5ebb23ebb294acab183ecf0769

        */
        private static final String pwd = MD5util.getMD5("wan131469six9");

        private static final String encode = "utf8";

        public static void send(String msgContent, String mobile) throws Exception {
            //组建请求
            String straddr = addr +
                    "?ac=send&uid="+userId+
                    "&pwd="+pwd+
                    "&mobile="+mobile+
                    "&encode="+encode+
                    "&content=" + msgContent;

            StringBuffer sb = new StringBuffer(straddr);
            System.out.println("URL:"+sb);

            //发送请求
            URL url = new URL(sb.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream()));

//返回结果
            String inputline = in.readLine();
            System.out.println("Response:"+inputline);

        }


        public static void main(String[] args) {
            try {
                send("今日短信推送内容是:不是除了你，我就没人要了。只是除了你，我谁都不想要。!【名言网】", "13452581564");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
