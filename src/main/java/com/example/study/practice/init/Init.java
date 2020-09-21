package com.example.study.practice.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-21 17:25
 **/
@Component
public class Init implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //③
    @Override
    public void afterPropertiesSet() {
        log.info("+++++++++++++++++++++++++++++++++:{}"," afterPropertiesSet");
    }
}
