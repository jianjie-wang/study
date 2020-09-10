package com.example.study.service.DTO;

/**
 * @program: ao-campaign-sales
 * @description:
 * @author: WangJJ
 * @create: 2020-08-06 14:38
 **/
public class URLContentDTO {

    private String title;

    private String content;

    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "URLContentDTO{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", image='" + image + '\'' +
            '}';
    }
}
