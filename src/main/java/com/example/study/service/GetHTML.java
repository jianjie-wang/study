package com.example.study.service;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-08-05 14:54
 **/
public class GetHTML {

    public static void main(String[] args) throws Exception {

//        //从url获取HTML文件
//        String url = getOneHtml("https://files.cnblogs.com/files/humi/wc.bmp");
//        System.out.println("111111111111111"+url);
//
//        //
//        String url2 = extractFilename(url);
//        System.out.println("2222222"+url2);

        //
        String url3 = content("https://files.cnblogs.com/files/humi/wc.bmp");
        System.out.println("333333"+url3);

    }
    public static String getOneHtml(String urlString)throws Exception{
        InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
        // read contents into string buffer
        StringBuilder input = new StringBuilder();
        int ch;
        while ((ch = in.read()) != -1) input.append((char) ch);
        //System.out.println(input);
        return input.toString();
    }

    public static String extractFilename(String htmlLine) {
        int srcIndex = htmlLine.toLowerCase().indexOf("src=");
        if (srcIndex == -1) { // 图片不存在，返回空字符串
            return "";
        } else {
            String htmlSrc = htmlLine.substring(srcIndex + 4);
            char splitChar = '\"'; // 默认为双引号，但也有可能为单引号
            if (htmlSrc.charAt(0) == '\'') {
                splitChar = '\'';
            }
            String[] firstSplit = htmlSrc.split(String.valueOf(splitChar));
            String path = firstSplit[1]; // 第0位为空字符串
            String[] secondSplit = path.split("[/\\\\]"); // 匹配正斜杠或反斜杠
            return secondSplit[secondSplit.length - 1];
        }
    }

    public static String content(String html) {
    List<String> titles = new ArrayList<String>();
    List<String> urls = new ArrayList<String>();

//    //假设我们获取的HTML的字符内容如下
//    String html = "<html><div id=\"blog_list\"><div class=\"blog_title\"><a href=\"url1\">第一篇博客</a></div><div class=\"blog_title\"><a href=\"url2\">第二篇博客</a></div><div class=\"blog_title\"><a href=\"url3\">第三篇博客</a></div></div></html>";
    //第一步，将字符内容解析成一个Document类
    Document doc = Jsoup.parse(html);

    //第二步，根据我们需要得到的标签，选择提取相应标签的内容
    Elements elements = doc.select("div[id=blog_list]").select("div[class=blog_title]");
    for( Element element : elements ){
        String title = element.text();
        titles.add(title);
        urls.add(element.select("a").attr("href"));
    }


    //输出测试
    for( String title : titles ){
        System.out.println(title);
        return title ;
    }

//    for( String url : urls ){
//        System.out.println(url);
//    }
     return null;
}

}
