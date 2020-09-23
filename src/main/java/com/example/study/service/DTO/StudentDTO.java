package com.example.study.service.DTO;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-02 11:35
 **/
public class StudentDTO implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "学校")
    private String School;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    private String createdBy;

    private Instant createdTime ;

    private String lastModifiedBy;

    private Instant lastModifiedTime ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Instant lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", School='" + School + '\'' +
                ", age=" + age +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedTime=" + lastModifiedTime +
                '}';
    }
}
