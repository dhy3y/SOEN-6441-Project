package view.property;
import java.util.Scanner;

import model.property.*;

public class HouseView {
    
    public Property getHouseDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Street name : ");
        String streetName = sc.next();
        System.out.println("Enter Plot number : ");
        String plotNumber = sc.next();
        System.out.println("Enter city : ");
        String city = sc.next();
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
        Property p1 = new HouseModel(streetName, plotNumber, city, postalCode, country, numberOfBedroom, numberOfBathroom, squareFoot);
        return p1;
    }

    public void printHouseDetails(String ID, Property p1) {

        System.out.println(p1);
    }
}
