package com.deloitte.pojo;

public class Subject
{
    private String number;

    private SubjectRecord subjectRecord;

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public SubjectRecord getSubjectRecord ()
    {
        return subjectRecord;
    }

    public void setSubjectRecord (SubjectRecord subjectRecord)
    {
        this.subjectRecord = subjectRecord;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [number = "+number+", subjectRecord = "+subjectRecord+"]";
    }
}
