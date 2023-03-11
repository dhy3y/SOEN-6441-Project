package model;

import java.sql.Date;

/**
 * LeaseModel
 */
public class LeaseModel {
    private String leaseID;
    private String propertyID;
    private String tenantID;
    private Date startDate;
    private Date endDate;
    private double amount;

    public LeaseModel(String leaseID, String propertyID, String tenantID, Date startDate, Date endDate, double amount) {
        this.leaseID = leaseID;
        this.propertyID = propertyID;
        this.tenantID = tenantID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public String getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(String leaseID) {
        this.leaseID = leaseID;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}