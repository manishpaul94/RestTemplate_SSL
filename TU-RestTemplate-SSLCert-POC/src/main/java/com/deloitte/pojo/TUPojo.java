package com.deloitte.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CreditBureau")
public class TUPojo {
	private CreditBureau creditBureau;

    public CreditBureau getCreditBureau ()
    {
        return creditBureau;
    }

    public void setCreditBureau (CreditBureau creditBureau)
    {
        this.creditBureau = creditBureau;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [creditBureau = "+creditBureau+"]";
    }

}
