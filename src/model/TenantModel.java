package model;

import java.util.ArrayList;

public class TenantModel {
    private String tenantID;
    private String tenantName;
    ArrayList<String> ownedLease = new ArrayList<String>();
    ArrayList<String> interestedProperty = new ArrayList<String>();
    ArrayList<String> notification = new ArrayList<String>();

    public TenantModel(String tenantID, String tenantName, ArrayList<String> ownedLease, ArrayList<String> interestedProperty, ArrayList<String> notification) {
        this.tenantID = tenantID;
        this.tenantName = tenantName;
        this.ownedLease = ownedLease;
        this.interestedProperty = interestedProperty;
        this.notification = notification;
    }

    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void getOwnedLease() {
    }

    public void setOwnedLease(String leaseID) {
        ownedLease.add(leaseID);
    }

    public void getInterestedProperty() {
    }

    public void setInterestedProperty(String leaseID) {
        interestedProperty.add(leaseID);
    }

    public void getNotification() {
    }

    public void setNotification(String newNotification) {
        notification.add(newNotification);
    }
}
