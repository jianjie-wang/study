package com.example.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: study
 * @description: wangJJ handsome
 * @author: WangJJ
 * @create: 2020-07-06 14:50
 **/
@Component
@ConfigurationProperties(prefix = "student")
public class StudentNameProperties {

    private String name;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
