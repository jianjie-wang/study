package com.example.study.service.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-03 14:32
 **/
public class StringService {

    public void text(int i){
        if (i==0) {
//            StringBuilder类也代表可变字符串对象。
//            StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。
//            不同的是：StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。
//            输出 domainuser555
            StringBuilder s = new StringBuilder("domain");
            s.append("user");
            s.append(555);
            System.out.println(s);
        }else {
//            String类是不可变类，即一旦一个String对象被创建以后，
//            包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。
//            再次给d赋值时，并不是对原来堆中实例对象进行重新赋值，而是生成一个新的实例对象
//            输出 String111
            String d = "String";
            d = "String111";
            System.out.println(d);
        }

        }


    public static void main(String[] args) {
        String url = "https://blog.csdn.net/qq_38777773/article/details/79533393";
        String t = "//blog.csdn.net/qq_38777773/article/details/79533393";
        System.out.println(url.substring(0  ,4));
        System.out.println(t.substring(0,2));

        //使用正则表达式过滤，
        String re = "((http|ftp|https)://)(([a-zA-Z0-9._-]+)|([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(([a-zA-Z]{2,6})|(:[0-9]{1,4})?)";
        String str = "";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(re);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        //若url==http://127.0.0.1:9040或www.baidu.com的，正则表达式表示匹配
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



        System.out.println(str);

    }

}
