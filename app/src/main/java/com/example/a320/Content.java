package com.example.a320;

public class Content
{
    int id;
    String img;
    String text;

    public Content(int id, String img, String text)
    {
        this.id = id;
        this.img = img;
        this.text = text;
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

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
