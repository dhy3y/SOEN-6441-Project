package controller;

import database.RentalDatabase;
import model.LeaseModel;
import model.TenantModel;
import model.property.Property;
import view.TenantView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TenantController {

    TenantModel model;
    TenantView view;
    RentalDatabase dbInstance = RentalDatabase.getInstance();


    public  TenantController (){
        view = new TenantView();
    }

    public void addTenant(TenantModel newTenant){
        // dbInstance.addTenant(view.getTenantDetails());
         dbInstance.addTenant(newTenant);

    }

    public void displayTenant(){
        HashMap<String, TenantModel> tenantList = dbInstance.getTenants();

        if(tenantList.isEmpty()) System.out.println("\n Its Empty Here ! \n ");
        else {

            System.out.println("All Tenants --->\n");

            Iterator<HashMap.Entry<String, TenantModel>> iterator = tenantList.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, TenantModel> entry = iterator.next();
                view.printTenantDetails(entry.getKey(), entry.getValue());
            }
        }

    }

    public ArrayList<String> getInterestedProperties(String tId){
        return dbInstance.getTenants().get(tId).getInterestedProperties();
    }

    public ArrayList<String> getNotificationList(String tId){
        return dbInstance.getTenants().get(tId).getNotificationList();
    }


    public void addLeaseToTenant(LeaseModel newLease) {
        String propertyID = newLease.getPropertyID();
        HashMap<String, TenantModel> tenantList = dbInstance.getTenants();

        tenantList.get(newLease.getTenantID()).setOwnedLeases(propertyID);
    }

    public void removeLeaseFromTenant(LeaseModel lease) {
        String propertyID = lease.getPropertyID();
        HashMap<String, TenantModel> tenantList = dbInstance.getTenants(); 
        tenantList.get(lease.getTenantID()).removeOwnedLease(propertyID);
        System.out.println("Lease removed from tenant");
    }

    public void addInterestedProperty(String propertyID, String tenantID) {
        HashMap<String, TenantModel> tenantList = dbInstance.getTenants();
        tenantList.get(tenantID).setInterestedProperties(propertyID);
    }

    public ArrayList<TenantModel> getAllTenants() {

        ArrayList<TenantModel> pp= new ArrayList<>();
        for (String key2 : dbInstance.getTenants().keySet()) {
            pp.add( dbInstance.getTenants().get(key2));
            // Do something with the property
        }

        return pp;
    }
}
