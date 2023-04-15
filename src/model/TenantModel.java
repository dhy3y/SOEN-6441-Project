package model;

import java.util.ArrayList;

public class TenantModel {

    private String tenantName;
    ArrayList<String> ownedLeases;
    private String tenantID;
    ArrayList<String> interestedProperties;
    ArrayList<String> notificationList;

    public TenantModel( String tenantName) {

        this.tenantName = tenantName;
        this.ownedLeases = new ArrayList<String>();
        this.interestedProperties = new ArrayList<String>();
        this.notificationList = new ArrayList<String>();
    }


    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public ArrayList<String> getOwnedLeases() {
        return ownedLeases;
    }

    public void setOwnedLeases(String leaseID) {
        ownedLeases.add(leaseID);
    }

    public void removeOwnedLease(String leaseID) {
        ownedLeases.remove(leaseID);
    }


    public ArrayList<String> getInterestedProperties() {
        return interestedProperties;
    }

    public void setInterestedProperties(String propertyID) {
        interestedProperties.add(propertyID);
    }

    public void removeInterestedProperty(String propertyID) {
        interestedProperties.remove(propertyID);
    }

    public ArrayList<String> getNotificationList() {
        return notificationList;
    }


    public void setNotificationList(String newNotification) {
        notificationList.add(newNotification);
    }

    public void removeNotification(String notification) {
        notificationList.remove(notification);
    }

    @Override
    public String toString() {
        return  "tenantID=" + tenantID + '\n' +
                "tenantName='" + tenantName +
                ",\nownedLeases=" + ownedLeases +
                ",\ninterestedProperties=" + interestedProperties +
                ",\nnotificationList=" + notificationList +
                '\n';
    }

    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }
}
