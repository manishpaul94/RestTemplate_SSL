package com.deloitte.pojo;

public class Tracking
{
    private String id;

    private String transactionTimeStamp;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTransactionTimeStamp ()
    {
        return transactionTimeStamp;
    }

    public void setTransactionTimeStamp (String transactionTimeStamp)
    {
        this.transactionTimeStamp = transactionTimeStamp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", transactionTimeStamp = "+transactionTimeStamp+"]";
    }
}
