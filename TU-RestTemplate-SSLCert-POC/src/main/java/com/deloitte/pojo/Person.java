package com.deloitte.pojo;

public class Person
{
    private String last;

    private String first;

    public String getLast ()
    {
        return last;
    }

    public void setLast (String last)
    {
        this.last = last;
    }

    public String getFirst ()
    {
        return first;
    }

    public void setFirst (String first)
    {
        this.first = first;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [last = "+last+", first = "+first+"]";
    }
}
