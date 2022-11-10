package com.deloitte.pojo;

public class DriverRiskAddon
{
    private Errors error;

    public Errors getError ()
    {
        return error;
    }

    public void setError (Errors error)
    {
        this.error = error;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [error = "+error+"]";
    }
}