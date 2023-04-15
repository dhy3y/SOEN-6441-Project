package model;

import java.util.Calendar;


/**
 * LeaseModel
 */
public class  LeaseModel {
    private String propertyID;
    private String tenantID;
    private Calendar startDate;
    private Calendar endDate;
    private double amount;


    private String endDateInString;
    private String startDateInString;

    public LeaseModel( String propertyID, String tenantID, Calendar startDate, Calendar endDate, double amount) {
        this.propertyID = propertyID;
        this.tenantID = tenantID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }



    public String getEndDateInString() {
        return endDateInString;
    }

    public void setEndDateInString(String endDateInString) {
        this.endDateInString = endDateInString;
    }

    public String getStartDateInString() {
        return startDateInString;
    }

    public void setStartDateInString(String startDateInString) {
        this.startDateInString = startDateInString;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PropertyID : " + propertyID +"\n Tenant ID : " + tenantID + "\n Start Date : "+ startDate.getTime() + "\n End Date : "+ endDate.getTime();
    }
}