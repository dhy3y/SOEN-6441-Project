package controller;

import database.RentalDatabase;
import model.LeaseModel;
import model.TenantModel;
import view.LeaseView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LeaseController{

    LeaseModel model;
    LeaseView view;

    RentalDatabase dbInstance = RentalDatabase.getInstance();

    public  LeaseController (){
        view = new LeaseView() ;
    }

    public void addLease(){
        dbInstance.addLease(view.getLeaseDetails());
        System.out.println("Lease Added");
    }

    public void displayLeases(){



        HashMap<String, LeaseModel> LeaseList = dbInstance.getLeases();

        if(LeaseList.isEmpty()) System.out.println("\n 8Its Empty Here !\n ");
        else{
            System.out.println("All Leases --->");

            Iterator<HashMap.Entry<String, LeaseModel>> iterator = LeaseList.entrySet().iterator();

            while(iterator.hasNext()) {
                Map.Entry<String, LeaseModel> entry = iterator.next();
                view.printLeaseDetails(entry.getKey(),entry.getValue());
            }
        }



    }
}
