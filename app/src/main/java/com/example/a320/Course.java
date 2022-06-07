package com.example.a320;

public class Course
{
    int id;
    String img;
    String content;

    public Course(int id, String img, String content)
    {
        this.id = id;
        this.img = img;
        this.content = content;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}