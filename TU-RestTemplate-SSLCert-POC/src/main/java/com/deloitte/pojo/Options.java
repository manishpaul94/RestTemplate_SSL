package com.deloitte.pojo;

public class Options
{
    private String country;

    private String contractualRelationship;

    private String language;

    private String pointOfSaleIndicator;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getContractualRelationship ()
    {
        return contractualRelationship;
    }

    public void setContractualRelationship (String contractualRelationship)
    {
        this.contractualRelationship = contractualRelationship;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getPointOfSaleIndicator ()
    {
        return pointOfSaleIndicator;
    }

    public void setPointOfSaleIndicator (String pointOfSaleIndicator)
    {
        this.pointOfSaleIndicator = pointOfSaleIndicator;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country = "+country+", contractualRelationship = "+contractualRelationship+", language = "+language+", pointOfSaleIndicator = "+pointOfSaleIndicator+"]";
    }
}
