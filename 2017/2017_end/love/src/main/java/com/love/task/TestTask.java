package com.love.task;

import com.love.commom.Constants;
import com.love.entity.FileEntity;
import com.love.mapper.WordsMapper;
import com.love.service.FileService;
import com.love.service.WordsService;
import com.love.utils.CommonUtil;
import com.love.utils.CrawlerUtils;
import com.love.utils.ForFile;
import com.love.utils.JavaSmsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2017/12/19 0019 10:28
 */
@Component
public class TestTask {

    @Autowired
    private WordsService service;

    @Autowired
    private FileService fileService;

    /**
     * 定时爬取网站内容
     * @throws IOException
     */
    @Scheduled(cron = " 0 44 11 * * ?")
    public void writeFile() throws IOException {
        System.out.println("============开始爬取网站内容==========");
        String fileName = new CrawlerUtils().getHtml("http://www.binzz.com/yulu2/3588.html");
        //存储数据
        FileEntity entity = new FileEntity();
        entity.setName(fileName);
        entity.setStatus(0);
        entity.setVersion(1);
        entity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        fileService.addFile(entity);
    }

    /**
     * 定时解析本地文件
     */
    @Scheduled(cron = "0 45 11 * * ?")
    public void readFile(){
        System.out.println("============开始解析本地文件==========");
        //1.获取还未解析的文件
        FileEntity entity = new FileEntity();
        entity.setStatus(0);
        List<FileEntity> list = fileService.findFile(entity);
        //2.解析文件
        String name = list.get(0).getName();
        if(CommonUtil.isNotEmpty(list)){
            String path = "D:\\file\\"+name+".txt";
            new ForFile().readFileContent(service,new File(path));
        }
        //3.修改状态
        fileService.updateFile(name);

    }

    /**
     * 定时发送短信
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendMessage(){

        System.out.println("==========开始发送短信============");
        //1.获取要发送的内容

        //2.获取要发送的号码
        //3.发送短信
        //new JavaSmsApi().tplSendSms(Constants.MODEL_ID,)
    }
}
