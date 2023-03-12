import java.util.Scanner;

import controller.property.PropertyController;

public class Driver {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Rental Management System");

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
                        PropertyController controller = new PropertyController();
                        if(type == 1) {
                            controller.addApartment();
                        }
                        else if(type == 2) {
                            controller.addCondo();
                        }
                        else if(type == 3) {
                            controller.addHouse();
                        }
                        else System.out.println("Wrong input");
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        PropertyController controller2 = new PropertyController();
                        controller2.displayProperties();
                        break;

                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

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


