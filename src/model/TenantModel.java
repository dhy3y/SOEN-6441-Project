package model;

import java.util.ArrayList;

public class TenantModel {

    private String tenantName;
    ArrayList<String> ownedLeases;
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

    public void removeOwnedLease(String lease) {
        ownedLeases.remove(lease);
    }


    public ArrayList<String> getInterestedProperties() {
        return interestedProperties;
    }

    public void setInterestedProperties(String leaseID) {
        interestedProperties.add(leaseID);
    }

    public void removeInterestedProperty(String property) {
        interestedProperties.remove(property);
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
        return  "tenantName='" + tenantName + '\'' +
                ", ownedLeases=" + ownedLeases +
                ", interestedProperties=" + interestedProperties +
                ", notificationList=" + notificationList +
                '\n';
    }
}
