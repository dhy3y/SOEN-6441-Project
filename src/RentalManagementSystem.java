import java.util.HashMap;
import java.util.Scanner;

import model.LeaseModel;
import model.TenantModel;
import model.property.*;

public class RentalManagementSystem {
    public static HashMap<String, HashMap<String, Property>> propertyDetails = new HashMap<String, HashMap<String, Property>>();
    public static HashMap<String, TenantModel> tenantDetails = new HashMap<String, TenantModel>();
    public static HashMap<String, LeaseModel> leaseDetails = new HashMap<String, LeaseModel>();
    
    void addProperty(Property p1) {
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

    HashMap<String, HashMap<String, Property>> getProperties(){
        return propertyDetails;
    }

    void addTenant(TenantModel t1) {
        tenantDetails.put(getTenantID(), t1);
    }

    HashMap<String, TenantModel> getTenants() {
        return tenantDetails;
    }

    void addLease(LeaseModel l1) {
        leaseDetails.put(getLeaseID(), l1);
    }

    HashMap<String, LeaseModel> getLeases() {
        return leaseDetails;
    }

    private String getPropertyID(String type) {
        return type.substring(0,1) + (propertyDetails.get(type).size()+1) ;
    }

    private String getTenantID() {
        return "T" + (tenantDetails.size()+1);
    }

    private String getLeaseID() {
        return "L" + (leaseDetails.size()+1) ;
    }

}

