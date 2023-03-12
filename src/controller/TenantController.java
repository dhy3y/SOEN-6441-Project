package controller;

import database.RentalDatabase;
import model.TenantModel;
import view.TenantView;

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

    public void addTenant(){
         dbInstance.addTenant(view.getTenantDetails());

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
}
