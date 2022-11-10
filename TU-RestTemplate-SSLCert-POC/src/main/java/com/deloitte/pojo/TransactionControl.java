package com.deloitte.pojo;

public class TransactionControl
{
    private Subscriber subscriber;

    private Identity identity;

    private String userRefNumber;

    private Options options;

    private Tracking tracking;

    public Subscriber getSubscriber ()
    {
        return subscriber;
    }

    public void setSubscriber (Subscriber subscriber)
    {
        this.subscriber = subscriber;
    }

    public Identity getIdentity ()
    {
        return identity;
    }

    public void setIdentity (Identity identity)
    {
        this.identity = identity;
    }

    public String getUserRefNumber ()
    {
        return userRefNumber;
    }

    public void setUserRefNumber (String userRefNumber)
    {
        this.userRefNumber = userRefNumber;
    }

    public Options getOptions ()
    {
        return options;
    }

    public void setOptions (Options options)
    {
        this.options = options;
    }

    public Tracking getTracking ()
    {
        return tracking;
    }

    public void setTracking (Tracking tracking)
    {
        this.tracking = tracking;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [subscriber = "+subscriber+", identity = "+identity+", userRefNumber = "+userRefNumber+", options = "+options+", tracking = "+tracking+"]";
    }
}