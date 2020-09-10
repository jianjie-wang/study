package com.example.study.practice.optionalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-09 15:28
 **/
@Service
public class OptionalService {
    private static final Logger Log = LoggerFactory.getLogger(OptionalService.class);


    public static void main(String[] args) {
        Optional<Integer> optionalS = null;

        Integer i = optionalS.orElseGet(()->0);

        if (i == 0){
            i = 7;
        }
        System.out.println(i);

    }

}
