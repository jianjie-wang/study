package com.example.study.practice.aggregate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}
