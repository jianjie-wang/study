package com.example.study.service.DTO;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-06 16:33
 **/
public class PetDTO {

    private String id;

    private String name;

    private String host;

    private Integer age;

    private String describe;

    private String color;

    private String classfy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClassfy() {
        return classfy;
    }

    public void setClassfy(String classfy) {
        this.classfy = classfy;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", age=" + age +
                ", describe='" + describe + '\'' +
                ", color='" + color + '\'' +
                ", classfy='" + classfy + '\'' +
                '}';
    }
}
