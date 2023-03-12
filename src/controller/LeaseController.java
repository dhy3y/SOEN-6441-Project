package controller;

import model.LeaseModel;
import view.LeaseView;

import java.rmi.dgc.Lease;

public class LeaseController{

    LeaseModel model;
    LeaseView view;

    public  LeaseController (LeaseModel model,LeaseView view){
        this.model = model;
        this.view = view;
    }

    public void addLease(){
       System.out.println("Lease Added");
    }

    public void displayLeases(){

        System.out.println("Leases --->");

    }



}
