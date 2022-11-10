package com.deloitte.pojo;

public class DriversLicense
{
    private String number;

    private String issuanceState;

    private String source;

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getIssuanceState ()
    {
        return issuanceState;
    }

    public void setIssuanceState (String issuanceState)
    {
        this.issuanceState = issuanceState;
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
        return "ClassPojo [number = "+number+", issuanceState = "+issuanceState+", source = "+source+"]";
    }
}
