package database;

import java.util.HashMap;

import model.*;
import model.property.*;

public class RentalDatabase {

    private static RentalDatabase instance = new RentalDatabase();

    private HashMap<String, HashMap<String, Property>> propertyDetails = new HashMap<String, HashMap<String, Property>>();
    private HashMap<String, TenantModel> tenantDetails = new HashMap<String, TenantModel>();
    private HashMap<String, LeaseModel> leaseDetails = new HashMap<String, LeaseModel>();

    private RentalDatabase() {}

    public static RentalDatabase getInstance() {
        if(instance == null)
            return new RentalDatabase();

        return instance;
    }
    
    public void addProperty(Property p1) {
        if(p1 instanceof ApartmentModel) {
            HashMap<String, Property> apartment = new HashMap<>();
            String id = getPropertyID("APT");
            apartment.put(id, p1);
            propertyDetails.put("APT", apartment);
        }
        else if(p1 instanceof CondoModel) {
            HashMap<String, Property> condo = new HashMap<>();
            String id = getPropertyID("CON");
            condo.put(id, p1);
            propertyDetails.put("CON", condo);
        }
        else if(p1 instanceof HouseModel) {
            HashMap<String, Property> house = new HashMap<>();
            String id = getPropertyID("HOU");
            house.put(id, p1);
            propertyDetails.put("HOU", house);
        }
    }

    public HashMap<String, HashMap<String, Property>> getProperties(){
        return propertyDetails;
    }


    public void addTenant(TenantModel t1) {
        String newTenantId=getTenantID();
        tenantDetails.put(newTenantId, t1);
        System.out.println("Tenant Added. ID : " + newTenantId);
    }

    public HashMap<String, TenantModel> getTenants() {
        return tenantDetails;
    }

    public void addLease(LeaseModel l1) {
        leaseDetails.put(getLeaseID(), l1);
    }

    public HashMap<String, LeaseModel> getLeases() {
        return leaseDetails;
    }

    private String getPropertyID(String type) {
        if(propertyDetails.get(type) == null) {
            return type.substring(0,1) + 1;
        }
        return type.substring(0,1) + (propertyDetails.get(type).size()+1) ;
    }

    private String getTenantID() {
        return "T" + (tenantDetails.size()+1);
    }

    private String getLeaseID() {
        return "L" + (leaseDetails.size()+1) ;
    }

}
