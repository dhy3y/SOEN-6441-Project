import java.util.Scanner;

import controller.LeaseController;
import controller.TenantController;
import controller.property.PropertyController;
import model.LeaseModel;

public class RentalManagementSystem {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            TenantController tenantController = new TenantController();
            PropertyController propertyController = new PropertyController();
            LeaseController leaseController = new LeaseController();

            System.out.println("-----Welcome to the Rental Management System-----\n\n");

            while (true) {
                //c - Various operation which user want to perform
                System.out.println("What do you want to do?");
                System.out.println("1. Add a Property");
                System.out.println("2. Add a tenant");
                System.out.println("3. Rent a unit");
                System.out.println("4. Display properties");
                System.out.println("5. Display tenants");
                System.out.println("6. Display rented units");
                System.out.println("7. Display vacant units");
                System.out.println("8. Display all leases");
                System.out.println("9. Exit");
                System.out.println("Please enter your choice >");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        printTypesOfProperty();
                        int type = scanner.nextInt();

                        if(type == 1) {
                            propertyController.addApartment();
                        }
                        else if(type == 2) {
                            propertyController.addCondo();
                        }
                        else if(type == 3) {
                            propertyController.addHouse();
                        }
                        else System.out.println("Wrong input");
                        break;
                    case 2:
                        tenantController.addTenant();
                        break;
                    case 3:
                        printTypesOfProperty();
                        int choice2 = scanner.nextInt();
                        String propertyType;

                        if(choice2 == 1) {
                            propertyType="APT";
                        }
                        else if(choice2 == 2) {
                            propertyType="CON";
                        }
                        else if(choice2 == 3) {
                           propertyType="HOU";
                        }
                        else{ System.out.println("\n Wrong Input"); break; }



                        System.out.println("Enter Property Id: ");
                        String propertyID= scanner.next();


                        if( propertyController.isRentedOrNot(propertyType,propertyID) ){
                            System.out.println("\n This property is already rented. " +
                                    "\n\n Do you want to get notified when it will get vacant ?" +
                                    "\n 1. Yes" +
                                    "\n 2. No");
                            int choice3 = scanner.nextInt();

                            if(choice3==1){
                                System.out.println("Tenant is Notified");
                            }


                        }
                        else{
                            LeaseModel newLease=leaseController.addLease(propertyID);
                            propertyController.rentProperty(propertyType,newLease.getPropertyID(), newLease.getTenantID());
                        }

                        break;
                    case 4:
                        propertyController.displayProperties();
                        break;

                    case 5:
                        tenantController.displayTenant();

                        break;
                    case 6:
                        propertyController.displayRentedProperties();

                        break;
                    case 7:
                        propertyController.displayVacantProperties();

                        break;
                    case 8: leaseController.displayLeases();

                        break;
                    case 9:

                        break;

                    default:
                        System.out.println("Enter valid input between 1 and 9");
                }
            }
        }


        static void printTypesOfProperty() {
            System.out.println("Choose the type of property");
            System.out.println("1. Apartment");
            System.out.println("2. Condo");
            System.out.println("3. House");
        }

    }

