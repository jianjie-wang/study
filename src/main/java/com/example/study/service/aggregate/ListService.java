package com.example.study.service.aggregate;

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


    public static void listJiHe(){
        List<String> liebiao = new ArrayList<String>();
        liebiao.add("王健杰");
        liebiao.add("王豪杰");
        liebiao.add("时玉颖");
        liebiao.add("王俊刚");
        System.out.println("ArrayList"+liebiao);

        List<String> liebi = new LinkedList<String>();
        liebi.add("王健杰");
        liebi.add("王豪杰");
        liebi.add("时玉颖");
        liebi.add("王俊刚");
        System.out.println("LinkedList"+liebi);



    }
}
