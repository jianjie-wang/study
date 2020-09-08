package com.example.study.service.aggregate;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 17:21
 **/
@Service
public class SetService {

    public static void setJiHe(){
        HashSet<String> hashSet = new HashSet();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        TreeSet<String> treeSet = new TreeSet();

        for (String data : Arrays.asList("B", "E", "D", "C", "A")) {
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }

        //不保证有序
        System.out.println("Ordering in HashSet :" + hashSet);

        //FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);

        //内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);

        Set<String> hashset = new HashSet<>();
        hashset.add("王健杰");
        hashset.add("王豪杰");
        hashset.add("时玉颖");
        hashset.add("王俊刚");
        System.out.println("HashSet"+hashset);

        Set<String> treeset = new TreeSet<>();
        treeset.add("王健杰");
        treeset.add("王豪杰");
        treeset.add("时玉颖");
        treeset.add("王俊刚");
        System.out.println("TreeSet"+treeset);
    }
}
