package com.example.study.service;

import com.example.study.config.StudentNameProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-27 18:26
 **/
@Service
public class ConfigService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentNameProperties studentNameProperties;

    public String student(){
        return studentNameProperties.getName();
    }

}
