package com.example.study.service;

import com.example.study.service.DTO.URLContentDTO;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-10 14:21
 **/
@Service
public class GetHTMLService {
    private static final Logger log = LoggerFactory.getLogger(GetHTMLService.class);

    //HttpURLConnection获取中国地区IP
    public String dididi() {
        Map<String,String> map = request("http://ftp.apnic.net/apnic/stats/apnic/delegated-apnic-latest");
        String s = parseOnline(map.get("result"));
        return s;
    }

    //获取页面内容
    private static Map<String,String> request(String url) {
        Map<String,String> response = new HashMap<String, String>();
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //设置请求方式
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            response.put("code",responseCode + "");
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while((inputLine = in.readLine())!=null){
                    responseBuffer.append(inputLine).append("\n");
                }
                in.close();
                response.put("result",responseBuffer.toString());
            }else{
                response.put("result","");
            }
        }catch (Exception e){
            response.put("result","failed");
        }
        return response;
    }

    //筛选中国区域的IP
    private static String parseOnline(String str1){
        String lists[] = str1.split("\n");
        StringBuilder sb = new StringBuilder();
        try {
            for (String str:lists) {
                if (str.startsWith("apnic") && str.contains("|CN|ipv4|")){
                    String a[] = str.split("\\|");
                    Integer mask = 32-(int)(Math.log(Double.valueOf(a[4]))/Math.log(2));
                    sb.append(a[3]).append("/").append(mask).append('\n');
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }



    public static URLContentDTO getContent(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String image = "";
        if (null != doc.getElementsByAttributeValueContaining("rel", "shortcut icon")) {
            String image1 = doc.getElementsByAttributeValueContaining("rel", "shortcut icon").attr("href");

            if (StringUtils.isNotBlank(image1)) {
                if ("http".equals(image1.substring(0, 4))) {
                    image = image1;
                } else if ("//".equals(image1.substring(0, 2))) {
                    image = image1;
                } else {
                    String domainName = getDomainName(url);
                    image = domainName + image1;
                }
            }
        }

        String content = "";
        if (null != doc.getElementsByAttributeValueContaining("name", "description")) {
            content = doc.getElementsByAttributeValueContaining("name", "description").attr("content");
        }

        String title = doc.getElementsByTag("title").text();

        URLContentDTO urlContentDTO = new URLContentDTO();
        urlContentDTO.setContent(content);
        urlContentDTO.setImage(image);
        urlContentDTO.setTitle(title);
        return urlContentDTO;
    }

    //获取URL域名
    private static String getDomainName(String url) {
        //使用正则表达式过滤，
        String re = "((http|ftp|https)://)(([a-zA-Z0-9._-]+)|([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(([a-zA-Z]{2,6})|(:[0-9]{1,4})?)";
        String str = "";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(re);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            str = url;
        } else {
            String[] split2 = url.split(re);
            if (split2.length > 1) {
                String substring = url.substring(0, url.length() - split2[1].length());
                str = substring;
            } else {
                str = split2[0];
            }
        }
        return str;
    }

}
