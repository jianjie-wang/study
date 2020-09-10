package com.example.study.practice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    public void load() {
        // 假设有一串字符串 96558&JQKA
        String asd = "96528&JQKA";
        // 想让它以&符号分离
        String[] sp = asd.split("&");
        // 直接输出该数组
        System.out.println("直接输出数组：" + sp);           //直接输出数组：[Ljava.lang.String;@2b9627bc
        // toString一下
        String dString = sp.toString();
        // 再输出
        System.out.println("toString输出数组：" + dString); // toString输出数组：[Ljava.lang.String;@2b9627bc
        // 用这转一下再输出(...源码其实就是循环数组再拼成一个字符串......)
        System.err.println("啦啦啦" + Arrays.toString(sp));// 啦啦啦[96528, JQKA]
        // 指定位置截取。1,3简单表示：1表示下标为1开始截取(数组下标从0开始)0,3表示下标为3结束。
        String string = asd.substring(1, 3);
        // 输出
        System.out.println("分离sub:" + string);    //分离sub:65
        System.err.println("数组长度" + sp.length); //数组长度2
        for (int i = 0; i < sp.length; i++) {
            System.err.println("第" + (i + 1) + "个:" + sp[i]);
        }
//        第1个:96528
//        第2个:JQKA

    }
    //拼接字符串
    public void pinjieString(){
        List<String> strings = new ArrayList<>();
        for (int i=0; i <= 20; i++){
            strings.add("字符串"+i);
        }
        System.out.println("原始集合:"+strings);
        String touser = strings.stream().collect(Collectors.joining("|"));
        System.out.println("拼接后:"+touser);
    }
//    原始集合:[字符串0, 字符串1, 字符串2, 字符串3, 字符串4, 字符串5, 字符串6, 字符串7, 字符串8, 字符串9, 字符串10, 字符串11, 字符串12, 字符串13, 字符串14, 字符串15, 字符串16, 字符串17, 字符串18, 字符串19, 字符串20]
//    拼接后:字符串0|字符串1|字符串2|字符串3|字符串4|字符串5|字符串6|字符串7|字符串8|字符串9|字符串10|字符串11|字符串12|字符串13|字符串14|字符串15|字符串16|字符串17|字符串18|字符串19|字符串20


}
