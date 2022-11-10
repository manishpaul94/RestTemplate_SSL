package com.deloitte.pojo;

public class Indicative
{
    private DriversLicense driversLicense;

    private Name name;
    
    private Address address;

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DriversLicense getDriversLicense ()
    {
        return driversLicense;
    }

    public void setDriversLicense (DriversLicense driversLicense)
    {
        this.driversLicense = driversLicense;
    }

    public Name getName ()
    {
        return name;
    }

    public void setName (Name name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [driversLicense = "+driversLicense+", name = "+name+"]";
    }
}
