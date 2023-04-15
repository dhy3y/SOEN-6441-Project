package view.property;
import java.util.Scanner;

import model.property.*;

public class CondoView {
    
    public static Property getCondoDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Unit number : ");
        String unitNumber = sc.next();
        System.out.println("Enter Plot number : ");
        String plotNumber = sc.next();
        sc.nextLine();
        System.out.println("Enter Street name : ");
        String streetName = sc.nextLine();
        System.out.println("Enter city : ");
        String city = sc.next();
        sc.nextLine();
        System.out.println("Enter postal code : ");
        String postalCode = sc.nextLine();
        System.out.println("Enter country : ");
        String country = sc.next();
        System.out.println("Enter number of bedrooms : ");
        int numberOfBedroom = sc.nextInt();
        System.out.println("Enter number of bathrooms : ");
        int numberOfBathroom = sc.nextInt();
        System.out.println("Enter square foot : ");
        double squareFoot = sc.nextDouble();
        Property p1 = new CondoModel(unitNumber, plotNumber, streetName, city, postalCode, country, numberOfBedroom, numberOfBathroom, squareFoot);
        return p1;
    }

    public void printCondoDetails(String ID,Property p1) {
        System.out.println("ID : " +  ID);
        System.out.println(p1);
    }
}
