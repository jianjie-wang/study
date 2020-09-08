package com.example.study.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-08-05 15:10
 **/
public class GetHTML2 {

    /**
     * @throws IOException
     * @Title: main
     * @Description: 测试方法
     * @throws
     */
    public static void main(String[] args) throws IOException {
        getImg("https://files.cnblogs.com/files/humi/wc.bmp");//
    }

    public static void getImg(String url) throws IOException{
        long startTime = System.currentTimeMillis();
        URL imgURL = new URL(url.trim());//转换URL
        HttpURLConnection urlConn = (HttpURLConnection) imgURL.openConnection();//构造连接
        urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
        urlConn.connect();
        System.out.println(":获取连接="+urlConn.getResponseMessage());
        if(urlConn.getResponseCode()==200){//返回的状态码是200 表示成功
            InputStream ins = urlConn.getInputStream(); //获取输入流,从网站读取数据到 内存中
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("TEST.jpg")));
            int len=0;
            byte[] buff = new byte[1024*10];//10k缓冲流 视你内存大小而定咯

            while(-1!=(len=(new BufferedInputStream(ins)).read(buff))){//长度保存到len,内容放入到 buff
                out.write(buff, 0, len);//将图片数组内容写入到图片文件
//				System.out.println(CatchIMG.class.toString()+":"+len+"byte已经写入到文件中，内容:  "+new String(buff));
            }
            urlConn.disconnect();
            ins.close();
            out.close();
            System.out.println("：获取图片完成,耗时="+((System.currentTimeMillis()-startTime)/1000)+"s");
        }
    }


}
