package com.example.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-23 16:44
 **/
@Service
public class MapService {
    private final Logger log = LoggerFactory.getLogger(MapService.class);

    public static void main(String[] args) {
        String ss = "王健杰";
        int s = ss.hashCode();
        System.out.println(s);
        int h;
        int q = (h = ss.hashCode()) ^ (h >>> 16);
        System.out.println(q);

        Integer c = 7 ;
        Integer v = 3;
        Integer b = c%v;
        Integer n = c/v;
        System.out.println(b);
        System.out.println(n);

        String wa = "wangjianjie";
        char wang[] = wa.toCharArray();
        System.out.println(wang[2]);

    }

}
