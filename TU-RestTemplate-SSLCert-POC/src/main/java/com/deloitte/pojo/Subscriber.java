package com.deloitte.pojo;

public class Subscriber
{
    private String memberCode;

    private String inquirySubscriberPrefixCode;

    private String industryCode;

    public String getMemberCode ()
    {
        return memberCode;
    }

    public void setMemberCode (String memberCode)
    {
        this.memberCode = memberCode;
    }

    public String getInquirySubscriberPrefixCode ()
    {
        return inquirySubscriberPrefixCode;
    }

    public void setInquirySubscriberPrefixCode (String inquirySubscriberPrefixCode)
    {
        this.inquirySubscriberPrefixCode = inquirySubscriberPrefixCode;
    }

    public String getIndustryCode ()
    {
        return industryCode;
    }

    public void setIndustryCode (String industryCode)
    {
        this.industryCode = industryCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [memberCode = "+memberCode+", inquirySubscriberPrefixCode = "+inquirySubscriberPrefixCode+", industryCode = "+industryCode+"]";
    }
}
