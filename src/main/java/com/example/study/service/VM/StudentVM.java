package com.example.study.service.VM;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-10-14 11:
 **/
public class StudentVM implements Serializable {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "学校")
    private String School;

    @ApiModelProperty(value = "年龄")
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentVM{" +
                "name='" + name + '\'' +
                ", School='" + School + '\'' +
                ", age=" + age +
                '}';
    }
}
