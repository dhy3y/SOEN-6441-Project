package view.property;
import java.util.Scanner;

import model.property.*;

public class ApartmentView {

    public static Property getApartmentDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter apartment number : ");
        String apartmentNumber = sc.next();
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
        Property p1 = new ApartmentModel(apartmentNumber, plotNumber, streetName, city, postalCode, country, numberOfBedroom, numberOfBathroom, squareFoot);
        return p1;
    }

    public void printApartmentDetails(String ID, Property p1) {
        System.out.println("ID : " +  ID);
        System.out.println(p1);
    }
}
