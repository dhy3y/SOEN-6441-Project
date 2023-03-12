package controller.property;

import java.util.HashMap;

import database.RentalDatabase;
import model.property.*;
import view.property.*;

public class PropertyController {

    private ApartmentView aptView;
    private CondoView conView;
    private HouseView houView;


    public PropertyController() {
        aptView = new ApartmentView();
        conView = new CondoView();
        houView = new HouseView();
    }

    public void addApartment() {
        Property property = aptView.getApartmentDetails();
        RentalDatabase instance = RentalDatabase.getInstance();
        instance.addProperty(property);
    }

    public void addCondo() {
        Property property = conView.getCondoDetails();
        RentalDatabase instance = RentalDatabase.getInstance();
        instance.addProperty(property);
    }

    public void addHouse() {
        Property property = houView.getHouseDetails();
        RentalDatabase instance = RentalDatabase.getInstance();
        instance.addProperty(property);
    }

    public void displayProperties() {
        RentalDatabase instance = RentalDatabase.getInstance();
        HashMap<String, HashMap<String, Property>> properties = instance.getProperties();

        for(HashMap.Entry<String, HashMap<String, Property>> set : properties.entrySet()) {
            for(HashMap.Entry<String, Property> set2 : properties.get(set.getKey()).entrySet()) {
                if(set2.getValue() instanceof ApartmentModel) {
                    aptView.printApartmentDetails(set2.getKey(), set2.getValue());
                }
                else if(set2.getValue() instanceof CondoModel) {
                    conView.printCondoDetails(set2.getKey(), set2.getValue());
                }
                else if(set2.getValue() instanceof HouseModel) {
                    houView.printHouseDetails(set2.getKey(), set2.getValue());
                }
            }
        }
    }
    
}
