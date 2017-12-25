package com.love.utils;

import com.love.entity.WordsEntity;
import com.love.mapper.WordsMapper;
import com.love.service.WordsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘英杰
 * @version 2017年12月19日 上午10:38:49
 */
public class ForFile {

    private static final Logger logger = Logger.getLogger(ForFile.class);

    //生成文件路径
    private static String path = "D:\\file\\";

    //文件路径+名称
    private static String filenameTemp;

    public static ForFile forFile;
    /**
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public boolean createFile(String fileName, String filecontent){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is "+filenameTemp);
            }
            //创建文件成功后，写入内容到文件里
            writeFileContent(filenameTemp, filecontent);
            //存储数据

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }

    /**
     * 读取文件内容
     * @param file
     * @return
     */
    public String readFileContent(WordsService service,File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if(s.indexOf("</p>") != -1 && s.indexOf("<div>") == -1 && s.indexOf("</a>") == -1){
                    String str = s.replace("</p>","").split("：")[1];
                    WordsEntity entity = new WordsEntity();
                    entity.setContent(str);
                    entity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    entity.setVersion(1);
                    entity.setStatus(0);
                    //存储数据
                    service.addWords(entity);
                    System.out.println(str);
                    result.append(str);
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    @PostConstruct
    public void init(){
        forFile = this;
    }

    /**
     * 删除文件
     * @param fileName 文件名称
     * @return
     */
    public boolean delFile(String fileName){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";
        File file  = new File(filenameTemp);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return bool;
    }
    /*public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        createFile(uuid+"myfile", "我的梦说别停留等待,就让光芒折射泪湿的瞳孔,映出心中最想拥有的彩虹,带我奔向那片有你的天空,因为你是我的梦 我的梦");
    }*/

}