package com.deloitte.pojo;

public class Product
{
    private String code;

    private Subject subject;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public Subject getSubject ()
    {
        return subject;
    }

    public void setSubject (Subject subject)
    {
        this.subject = subject;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", subject = "+subject+"]";
    }
}