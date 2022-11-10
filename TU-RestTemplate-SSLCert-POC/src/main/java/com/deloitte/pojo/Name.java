package com.deloitte.pojo;

public class Name
{
    private Person person;

    private String source;

    public Person getPerson ()
    {
        return person;
    }

    public void setPerson (Person person)
    {
        this.person = person;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [person = "+person+", source = "+source+"]";
    }
}
