package com.example.study.service.aggregate;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 17:21
 **/
public class MapService {


    public static void mapJiHe() {
        //    1、注释掉2-9，遍历map输出结果
//    2、不注释2-9，遍历map输出，移除2-9后的结果
//    3、1和2的结果顺序是不一致的
        Map<String, String> ji = new HashMap<String, String>();
        ji.put("one", "1");
        ji.put("two", "2");
        ji.put("three", "3");
        ji.put("four", "4");
        ji.put("five", "5");
        ji.put("six", "6");
        ji.put("seven", "7");
        ji.put("eight", "8");
        ji.put("nine", "9");
        ji.put("ten", "10");
        ji.put("eleven", "11");
        ji.put("twelve", "12");
        ji.put("thirteen", "13");
        ji.put("fourteen", "14");
        ji.put("fifteen", "15");
        ji.put("sixteen", "16");
        ji.put("seventeen", "17");
        ji.put("eighteen", "18");
        ji.put("nineteen", "19");
        ji.put("twenty", "20");
        System.out.println("HashMap" + ji);

        Map<Integer, String> hashtable = new Hashtable<Integer, String>();
        hashtable.put(1, "赵");
        hashtable.put(2, "钱");
        hashtable.put(3, "孙");
        hashtable.put(4, "李");
        hashtable.put(5, "赵");
        hashtable.put(6, "钱");
        hashtable.put(7, "孙");
        hashtable.put(8, "李");
        hashtable.put(9, "赵");
        hashtable.put(10, "钱");
        hashtable.put(11, "孙");
        hashtable.put(12, "李");
        System.out.println("hashtable" + hashtable);

        Map<String, String> treemap = new TreeMap<String, String>();
        treemap.put("赵", "赵");
        treemap.put("钱", "钱");
        treemap.put("孙", "孙");
        treemap.put("李", "李");
        System.out.println("TreeMap" + treemap);
    }
}
