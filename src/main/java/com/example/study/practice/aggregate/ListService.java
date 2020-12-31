package com.example.study.practice.aggregate;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 17:21
 **/
@Service
public class ListService {

    public static void main(String[] args) {
        listJiHe();
        arraysLiast();
    }
    public static void listJiHe(){
        List<String> liebiao = new ArrayList<String>();
        liebiao.add("王健");
        liebiao.add("王健林");
        liebiao.add("健哥哥");
        liebiao.add("嘀嘀嘀");
        System.out.println("ArrayList"+liebiao);

        List<String> liebi = new LinkedList<String>();
        liebi.add("王健");
        liebi.add("王健林e");
        liebi.add("健哥哥e");
        liebi.add("嘀嘀嘀");
        System.out.println("LinkedList"+liebi);

        //取交集
        liebiao.retainAll(liebi);
        System.out.println(liebiao);
    }

    //Arrays和List转换,四种方法
    public static void arraysLiast(){
        String[] arrayString = new String[3];

        //1.直接转换，只能查改，不能增删
        List list1 = Arrays.asList(arrayString);

        //2.通过ArrayList的构造器，将Arrays.asList(strArray)的返回值由java.util.Arrays.ArrayList转为java.util.ArrayList
        //可增删改查，处理的List数据量不大
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(arrayString)) ;

        //3.先创建一个和数组相同的List，然后通过Collections.addAll()方法将数组转为二进制，然后添加到List
        //可增删改查，效率高，处理数据量多的List
        ArrayList<String> list3 = new ArrayList<>(arrayString.length);
        Collections.addAll(list3,arrayString);

        //4.java8 可通过stream转换
        List<String> list4 = Stream.of(arrayString).collect(Collectors.toList());

    }

}
