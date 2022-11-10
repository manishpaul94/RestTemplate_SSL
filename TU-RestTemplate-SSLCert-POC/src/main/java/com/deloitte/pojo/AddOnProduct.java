package com.deloitte.pojo;

public class AddOnProduct
{
    private String code;

    private DriverRiskAddon driverRiskAddon;

    private String status;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public DriverRiskAddon getDriverRiskAddon ()
    {
        return driverRiskAddon;
    }

    public void setDriverRiskAddon (DriverRiskAddon driverRiskAddon)
    {
        this.driverRiskAddon = driverRiskAddon;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", driverRiskAddon = "+driverRiskAddon+", status = "+status+"]";
    }
}
