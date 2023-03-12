package view;


import model.LeaseModel;
import model.TenantModel;
import utils.CustomDate;

import java.util.Calendar;
import java.util.Scanner;

public class TenantView {

    public TenantModel getTenantDetails() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Tenant Name : ");
        String tenantName= scan.next();


        return new TenantModel(tenantName);
    }

    public void printTenantDetails(LeaseModel l1) {
        System.out.println(l1);
    }

}
