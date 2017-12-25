package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("====================开始密码破解========================");
		long start = new Date().getTime();
		//密码登录   银行卡密码  6位
		int x = 1;
		String pwd = "962490";
		for(int a=0;a<10;a++){
			String aa = a+"";
			for(int b=0;b<10;b++){
				String bb = b+"";
				for(int c=0;c<10;c++){
					String cc = c+"";
					for(int d=0;d<10;d++){
						String dd = d+"";
						for(int e=0;e<10;e++){
							String ee = e+"";
							for(int f=0;f<10;f++){
								String str = aa+bb+cc+dd+ee+f+"";
								if(str.equals(pwd)){
									long end = new Date().getTime();
									long l = (end-start);
									System.out.println("====================破解成功===========密码是："+str+"=====运行次数："+x+"==消耗时间："+l+"毫秒");
								}else{
									x++;
								}
							}
						}
					}
				}
			}
		}
	}

	
}
