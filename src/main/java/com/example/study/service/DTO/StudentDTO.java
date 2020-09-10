package com.example.study.service.DTO;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-02 11:35
 **/
public class StudentDTO implements Serializable {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "学校")
    private String School;

    @ApiModelProperty(value = "年龄")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
