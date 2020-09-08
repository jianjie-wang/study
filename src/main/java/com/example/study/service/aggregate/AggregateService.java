package com.example.study.service.aggregate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 17:26
 **/
@Service
public class AggregateService {
    private final Logger log = LoggerFactory.getLogger(AggregateService.class);

    @Autowired
    private SetService setService;


    public void jiHe(){
        log.debug("ser 集合");
        setService.setJiHe();
    }

}
