package model;

import java.util.ArrayList;

public class TenantModel {
    String tenantID;
    String tenantName;
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

    public ArrayList<String> getOwnedLease() {
        return ownedLease;
    }

    public void setOwnedLease(ArrayList<String> ownedLease) {
        this.ownedLease = ownedLease;
    }

    public ArrayList<String> getInterestedProperty() {
        return interestedProperty;
    }

    public void setInterestedProperty(ArrayList<String> interestedProperty) {
        this.interestedProperty = interestedProperty;
    }

    public ArrayList<String> getNotification() {
        return notification;
    }

    public void setNotification(ArrayList<String> notification) {
        this.notification = notification;
    }
}
