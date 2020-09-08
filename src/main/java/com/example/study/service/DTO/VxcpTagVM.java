package com.example.study.service.DTO;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @program: ao-campaign-sales
 * @description:
 * @create: 2020-07-31 17:52
 **/
@ApiModel
public class VxcpTagVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] groupId;

    private String[] tagId;

    public String[] getGroupId() {
        return groupId;
    }

    public void setGroupId(String[] groupId) {
        this.groupId = groupId;
    }

    public String[] getTagId() {
        return tagId;
    }

    public void setTagId(String[] tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "VxcpTagVM{" +
            "groupId=" + Arrays.toString(groupId) +
            ", tagId=" + Arrays.toString(tagId) +
            '}';
    }
}
