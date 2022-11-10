package com.deloitte.pojo;

public class SubjectRecord
{
    private AddOnProduct[] addOnProduct;

    private Indicative indicative;

    public AddOnProduct[] getAddOnProduct ()
    {
        return addOnProduct;
    }

    public void setAddOnProduct (AddOnProduct[] addOnProduct)
    {
        this.addOnProduct = addOnProduct;
    }

    public Indicative getIndicative ()
    {
        return indicative;
    }

    public void setIndicative (Indicative indicative)
    {
        this.indicative = indicative;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [addOnProduct = "+addOnProduct+", indicative = "+indicative+"]";
    }
}
