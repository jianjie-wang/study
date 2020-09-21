package com.example.study.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-21 16:45
 **/
@Component
public class Annotation {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @PostConstruct
    public void init() {
        log.info("=================================:{}"," @PostConstruct");
        new Thread(this::worker1).start();
        new Thread(this::worker2).start();
    }

    private void worker1(){
        log.info("=================================:{}"," worker1");
    }

    private void worker2(){
        log.info("=================================:{}"," worker2");
    }

}
