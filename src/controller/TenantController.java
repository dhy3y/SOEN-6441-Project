package controller;

import model.LeaseModel;
import model.TenantModel;
import view.LeaseView;
import view.TenantView;

public class TenantController {

    TenantModel model;
    TenantView view;


    public  TenantController (TenantModel model,TenantView view){
        this.model = model;
        this.view = view;
    }

    public void addTenant(){
        System.out.println("Lease Added");
    }

    public void displayTenant(){

        System.out.println("Leases --->");

    }
}
