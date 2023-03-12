package controller.property;

import java.util.ArrayList;
import java.util.HashMap;

import database.RentalDatabase;
import model.TenantModel;
import model.property.*;
import view.property.*;

public class PropertyController {

    private ApartmentView aptView;
    private CondoView conView;
    private HouseView houView;

    RentalDatabase dbInstance = RentalDatabase.getInstance();


    public PropertyController() {
        aptView = new ApartmentView();
        conView = new CondoView();
        houView = new HouseView();
    }

    public void addApartment() {
        Property property = aptView.getApartmentDetails();
        dbInstance.addProperty(property);
        System.out.println("Apartment added!");
    }

    public void addCondo() {
        Property property = conView.getCondoDetails();
        dbInstance.addProperty(property);
        System.out.println("Condo added!");
    }

    public void addHouse() {
        Property property = houView.getHouseDetails();
        dbInstance.addProperty(property);
        System.out.println("House added!");
    }

    public void rentProperty(String propertyType,String propertyID,String tenantID) {
        dbInstance.getProperties().get(propertyType).get(propertyID).setRented(Boolean.TRUE);
    }

    public void vacantProperty(String propertyType,String propertyID) {
        dbInstance.getProperties().get(propertyType).get(propertyID).setRented(Boolean.FALSE);
        notifyInterestedTenants(propertyID);
    }

    public boolean isRentedOrNot(String propertyType,String propertyID) {
       return dbInstance.getProperties().get(propertyType).get(propertyID).getRented();
    }


    public void displayProperties() {
        HashMap<String, HashMap<String, Property>> propertyList = dbInstance.getProperties();

        for(HashMap.Entry<String, HashMap<String, Property>> propertySet : propertyList.entrySet()) {
            for(HashMap.Entry<String, Property> singleProperty : propertyList.get(propertySet.getKey()).entrySet()) {
                printPropertyDetail(singleProperty);
            }
        }
    }

    public void displayRentedProperties() {
        HashMap<String, HashMap<String, Property>> propertyList = dbInstance.getProperties();

        if(propertyList.isEmpty()) System.out.println("\n It's Empty Here !\n ");
        else{
            for(HashMap.Entry<String, HashMap<String, Property>> set : propertyList.entrySet()) {
                for(HashMap.Entry<String, Property> singleProperty : propertyList.get(set.getKey()).entrySet()) {
                    if(singleProperty.getValue().getRented()== Boolean.TRUE)  printPropertyDetail(singleProperty);
                }
            }

        }
    }

    public void displayVacantProperties() {
        HashMap<String, HashMap<String, Property>> propertyList = dbInstance.getProperties();

        if(propertyList.isEmpty()) System.out.println("\n It's Empty Here !\n ");
        else{
            for(HashMap.Entry<String, HashMap<String, Property>> set : propertyList.entrySet()) {
                for(HashMap.Entry<String, Property> singleProperty : propertyList.get(set.getKey()).entrySet()) {
                    if(singleProperty.getValue().getRented()== Boolean.FALSE)  printPropertyDetail(singleProperty);
                }
            }

        }
    }

    private void printPropertyDetail( HashMap.Entry<String, Property> propertySet){
        if(propertySet.getValue() instanceof ApartmentModel) {
            aptView.printApartmentDetails(propertySet.getKey(), propertySet.getValue());
        }
        else if(propertySet.getValue() instanceof CondoModel) {
            conView.printCondoDetails(propertySet.getKey(), propertySet.getValue());
        }
        else if(propertySet.getValue() instanceof HouseModel) {
            houView.printHouseDetails(propertySet.getKey(), propertySet.getValue());
        }
    }


    public void notifyInterestedTenants(String propertyID) {
        HashMap<String, HashMap<String, Property>> propertyList = dbInstance.getProperties();
        HashMap<String, TenantModel> allTenants = dbInstance.getTenants();
        Property property = propertyList.get(propertyID.substring(0,1)).get(propertyID);
        ArrayList<String> interestedTenants = property.getInterestedTenants();
        
        for(String tenantID : interestedTenants) {
            allTenants.get(tenantID).setNotificationList(propertyID + " is now available! \n");
        }
    }

}
