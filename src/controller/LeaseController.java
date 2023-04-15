package controller;

import database.RentalDatabase;
import model.LeaseModel;
import model.TenantModel;
import view.LeaseView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LeaseController{

    public LeaseModel model;
   public LeaseView view;

    public RentalDatabase dbInstance = RentalDatabase.getInstance();

    public  LeaseController (){
        view = new LeaseView() ;
    }

    public LeaseModel addLease(LeaseModel newLease){
//        LeaseModel newLease = view.getLeaseDetails(propertyID);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        newLease.setEndDateInString( sdf.format(newLease.getEndDate().getTime()));
        newLease.setStartDateInString(sdf.format(newLease.getStartDate().getTime()));
        dbInstance.addLease(newLease);
        System.out.println("\n New Lease Created");
        return newLease;
    }

    public LeaseModel removeLease(String leaseID) {
        HashMap<String, LeaseModel> leaseList = dbInstance.getLeases();
        LeaseModel removedLease = leaseList.get(leaseID);
        leaseList.remove(leaseID);
        return removedLease;
    }

    public void displayLeases(){

        HashMap<String, LeaseModel> leaseList = dbInstance.getLeases();

        if(leaseList.isEmpty()) System.out.println("\n It's Empty Here !\n ");
        else{
            System.out.println("All Leases --->");

            Iterator<HashMap.Entry<String, LeaseModel>> iterator = leaseList.entrySet().iterator();

            while(iterator.hasNext()) {
                Map.Entry<String, LeaseModel> entry = iterator.next();
                view.printLeaseDetails(entry.getKey(),entry.getValue());
            }
        }
    }

    public ArrayList<LeaseModel> getAllLeases() {

        ArrayList<LeaseModel> pp= new ArrayList<>();
        for (String key2 : dbInstance.getLeases().keySet()) {
            pp.add( dbInstance.getLeases().get(key2));
            // Do something with the property
        }

        return pp;
    }

    
}
