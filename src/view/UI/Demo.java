package view.UI;

import controller.LeaseController;
import controller.TenantController;
import controller.property.PropertyController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import model.LeaseModel;
import model.TenantModel;
import model.property.ApartmentModel;
import model.property.CondoModel;
import model.property.HouseModel;
import set.Property;
import utils.CustomDate;

import java.util.ArrayList;
import java.util.Calendar;

public class Demo extends Application {

    private static PropertyController pc;
    private static LeaseController lc;
    private static TenantController tc;
    private static TableView propertyView;

    private static TableView tenantView;
    private static TableView leaseView;

    public Demo(){
        pc= new PropertyController();
        lc= new LeaseController();
        tc= new TenantController();
    }
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place a button in the scene
        primaryStage.setTitle("Rental Management System");
        //Property option
        Menu menu1 = new Menu("Property");
        MenuItem menuItem1 = new MenuItem("Add Apartment");
        MenuItem menuItem2 = new MenuItem("Add Condo");
        MenuItem menuItem3 = new MenuItem("Add House");
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);

        //Admin option
        Menu menu2 = new Menu("Admin");
        MenuItem menuItem4 = new MenuItem("Rent a Property");
        MenuItem menuItem5= new MenuItem("Add Tenant");
        MenuItem menuItem6 = new MenuItem("Terminate Lease");

        menu2.getItems().add(menuItem4);
        menu2.getItems().add(menuItem5);
        menu2.getItems().add(menuItem6);


        //add Tenant
        GridPane tenantGrid = new GridPane();
        tenantGrid.setHgap(10);
        tenantGrid.setVgap(10);
        tenantGrid.setPadding(new Insets(10, 10, 10, 10));

        Label tenantidLabel = new Label("Enter Tenant ID:");
        TextField tenantidField = new TextField();
        tenantGrid.add(tenantidLabel, 0, 0);
        tenantGrid.add(tenantidField, 1, 0);

        Label tenantNameLabel = new Label("Enter Tenant Name :");
        TextField tenantNameField = new TextField();
        tenantGrid.add(tenantNameLabel, 0, 1);
        tenantGrid.add(tenantNameField, 1, 1);

        Button tenantSubmitButton = new Button("Submit");
        tenantGrid.add(tenantSubmitButton, 1, 3);

        // Create the modal window
        Stage tenantModal = new Stage();
        tenantModal.initModality(Modality.APPLICATION_MODAL);
        tenantModal.initOwner(primaryStage);
        tenantModal.setTitle("Tenant details");
        tenantModal.setScene(new Scene(tenantGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem5.setOnAction(event -> {
            tenantModal.showAndWait();
        });

        //when we click submit button on tenant form
        tenantSubmitButton.setOnAction(event -> {
           new Thread(() -> {
               String tenantID =tenantidField.getText();
               String tenantName =tenantNameField.getText();

               TenantModel tm = new TenantModel(tenantName);
               tc.addTenant(tm);

               Platform.runLater(new Runnable() {
                   @Override
                   public void run() {
                       tenantidField.clear();
                       tenantNameField.clear();

                       updateTenantView();
                       tenantView.refresh();

                       tenantModal.close();

                       showSuccessAlert("Tenant Added Successfully",tm.toString());
                   }
               });
           }).start();
        });


        Menu menu3 = new Menu("Tenant");
        MenuItem menuItem8 = new MenuItem("Show interested Property");
        MenuItem menuItem9 = new MenuItem("Show Notifications");

        menu3.getItems().add(menuItem8);
        menu3.getItems().add(menuItem9);

        //add help
        Menu menu4 = new Menu("Help");
        MenuItem menuItem11 = new MenuItem("About Us");
        menu4.getItems().add(menuItem11);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        menuBar.getMenus().add(menu4);

        //Apartment details form
        GridPane apartmentGrid = new GridPane();
        apartmentGrid.setHgap(10);
        apartmentGrid.setVgap(10);
        apartmentGrid.setPadding(new Insets(10, 10, 10, 10));

        Label apartmentLabel = new Label("Enter Apartment number:");
        TextField apartmentField = new TextField();
        apartmentGrid.add(apartmentLabel, 0, 0);
        apartmentGrid.add(apartmentField, 1, 0);

        Label plotLabel = new Label("Enter Plot number:");
        TextField plotField = new TextField();
        apartmentGrid.add(plotLabel, 0, 1);
        apartmentGrid.add(plotField, 1, 1);

        Label streetLabel = new Label("Enter Street name:");
        TextField streetField = new TextField();
        apartmentGrid.add(streetLabel, 0, 2);
        apartmentGrid.add(streetField, 1, 2);

        Label cityLabel = new Label("Enter City:");
        TextField cityField = new TextField();
        apartmentGrid.add(cityLabel, 0, 3);
        apartmentGrid.add(cityField, 1, 3);

        Label postalLabel = new Label("Enter Postal code:");
        TextField postalField = new TextField();
        apartmentGrid.add(postalLabel, 0, 4);
        apartmentGrid.add(postalField, 1, 4);

        Label countryLabel = new Label("Enter Country:");
        TextField countryField = new TextField();
        apartmentGrid.add(countryLabel, 0, 5);
        apartmentGrid.add(countryField, 1, 5);

        Label noOfbedroomsLabel = new Label("Enter number of bedrooms:");
        TextField noOfbedroomsField = new TextField();
        apartmentGrid.add(noOfbedroomsLabel, 0, 6);
        apartmentGrid.add(noOfbedroomsField, 1, 6);

        Label noOfbathroomsLabel = new Label("Enter number of bathrooms:");
        TextField noOfbathroomsField = new TextField();
        apartmentGrid.add(noOfbathroomsLabel, 0, 7);
        apartmentGrid.add(noOfbathroomsField, 1, 7);

        Label squarefootLabel = new Label("Enter number of Squarefoot:");
        TextField squarefootField = new TextField();
        apartmentGrid.add(squarefootLabel, 0, 8);
        apartmentGrid.add(squarefootField, 1, 8);

        Button submitButton = new Button("Submit");
        apartmentGrid.add(submitButton, 1, 9);

        // Create the modal window
        Stage apartmentModal = new Stage();
        apartmentModal.initModality(Modality.APPLICATION_MODAL);
        apartmentModal.initOwner(primaryStage);
        apartmentModal.setTitle("Apartment details");
        apartmentModal.setScene(new Scene(apartmentGrid, 400, 500));

        // Show the modal window when the "Open" menu item is clicked
        menuItem1.setOnAction(event -> {
            apartmentModal.showAndWait();
        });
        //when we click submit button for apartment form
        submitButton.setOnAction(event -> {
            new Thread(() -> {
                String apartmentNumber =apartmentField.getText();
                String plotNumber =plotField.getText();
                String streetName =streetField.getText();
                String city =cityField.getText();
                String postalCode =postalField.getText();
                String country =countryField.getText();
                int noOfbedrooms =Integer.valueOf(noOfbedroomsField.getText());
                int noOfbathrooms =Integer.valueOf(noOfbathroomsField.getText());
                double squareFoot =Double.valueOf(squarefootField.getText());

                model.property.Property apt = new ApartmentModel(apartmentNumber,plotNumber,streetName,city,postalCode,country,noOfbedrooms,noOfbathrooms,squareFoot);
                pc.addApartment(apt);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        apartmentField.clear();
                        plotField.clear();
                        streetField.clear();
                        cityField.clear();
                        postalField.clear();
                        countryField.clear();
                        noOfbathroomsField.clear();
                        noOfbedroomsField.clear();
                        squarefootField.clear();

                        apartmentModal.close();

                        showSuccessAlert("Property Added Successfully",apt.toString());
                        updatePropertyView();
                        propertyView.refresh();
                    }
                });
            }).start();
        });

        //Condo details form
        GridPane condoGrid = new GridPane();
        condoGrid.setHgap(10);
        condoGrid.setVgap(10);
        condoGrid.setPadding(new Insets(10, 10, 10, 10));

        Label condoUnitLabel = new Label("Enter Unit number:");
        TextField condoUnitField = new TextField();
        condoGrid.add(condoUnitLabel, 0, 0);
        condoGrid.add(condoUnitField, 1, 0);

        Label condoPlotLabel = new Label("Enter Plot number:");
        TextField condoPlotField = new TextField();
        condoGrid.add(condoPlotLabel, 0, 1);
        condoGrid.add(condoPlotField, 1, 1);

        Label condoStreetLabel = new Label("Enter Street name:");
        TextField condoStreetField = new TextField();
        condoGrid.add(condoStreetLabel, 0, 2);
        condoGrid.add(condoStreetField, 1, 2);

        Label condoCityLabel = new Label("Enter City:");
        TextField condoCityField = new TextField();
        condoGrid.add(condoCityLabel, 0, 3);
        condoGrid.add(condoCityField, 1, 3);

        Label condoostalLabel = new Label("Enter Postal code:");
        TextField condoPostalField = new TextField();
        condoGrid.add(condoostalLabel, 0, 4);
        condoGrid.add(condoPostalField, 1, 4);

        Label condoCountryLabel = new Label("Enter Country:");
        TextField condoCountryField = new TextField();
        condoGrid.add(condoCountryLabel, 0, 5);
        condoGrid.add(condoCountryField, 1, 5);

        Label condonoOfbedroomsLabel = new Label("Enter number of bedrooms:");
        TextField condonoOfbedroomsField = new TextField();
        condoGrid.add(condonoOfbedroomsLabel, 0, 6);
        condoGrid.add(condonoOfbedroomsField, 1, 6);

        Label condonoOfbathroomsLabel = new Label("Enter number of bathrooms:");
        TextField condonoOfbathroomsField = new TextField();
        condoGrid.add(condonoOfbathroomsLabel, 0, 7);
        condoGrid.add(condonoOfbathroomsField, 1, 7);

        Label condosquarefootLabel = new Label("Enter number of Squarefoot:");
        TextField condosquarefootField = new TextField();
        condoGrid.add(condosquarefootLabel, 0, 8);
        condoGrid.add(condosquarefootField, 1, 8);

        // Create the modal window
        Stage condoModal = new Stage();
        condoModal.initModality(Modality.APPLICATION_MODAL);
        condoModal.initOwner(primaryStage);
        condoModal.setTitle("Condo details");
        condoModal.setScene(new Scene(condoGrid, 400, 500));

        // Show the modal window when the "Open" menu item is clicked
        menuItem2.setOnAction(event -> {
            condoModal.showAndWait();
        });

        Button condoSubmitButton = new Button("Submit");
        condoGrid.add(condoSubmitButton, 1, 9);

      

        condoSubmitButton.setOnAction(event -> {
            new Thread(() -> {
                String unitNumber =condoUnitField.getText();
                String plotNumber =condoPlotField.getText();
                String streetName =condoStreetField.getText();
                String city = condoCityField.getText();
                String postalCode =condoPostalField.getText();
                String country =condoCountryField.getText();
                int noOfbedrooms =Integer.valueOf(condonoOfbedroomsField.getText());
                int noOfbathrooms =Integer.valueOf(condonoOfbathroomsField.getText());
                double squareFoot =Double.valueOf(condosquarefootField.getText());

                model.property.Property apt = new CondoModel(unitNumber,plotNumber,streetName,city,postalCode,country,noOfbedrooms,noOfbathrooms,squareFoot);
                pc.addCondo(apt);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        apartmentField.clear();
                        plotField.clear();
                        streetField.clear();
                        cityField.clear();
                        postalField.clear();
                        countryField.clear();
                        noOfbathroomsField.clear();
                        noOfbedroomsField.clear();
                        squarefootField.clear();

                        updatePropertyView();
                        propertyView.refresh();
                        condoModal.close();

                        showSuccessAlert("Property Added Successfully",apt.toString());
                    }
                });
            }).start();
        });

        //House details form
        GridPane houseGrid = new GridPane();
        houseGrid.setHgap(10);
        houseGrid.setVgap(10);
        houseGrid.setPadding(new Insets(10, 10, 10, 10));

        Label houseStreetLabel = new Label("Enter Street name:");
        TextField houseStreetField = new TextField();
        houseGrid.add(houseStreetLabel, 0, 0);
        houseGrid.add(houseStreetField, 1, 0);

        Label housePlotLabel = new Label("Enter Plot number:");
        TextField housePlotField = new TextField();
        houseGrid.add(housePlotLabel, 0, 1);
        houseGrid.add(housePlotField, 1, 1);



        Label houseCityLabel = new Label("Enter City:");
        TextField houseCityField = new TextField();
        houseGrid.add(houseCityLabel, 0, 2);
        houseGrid.add(houseCityField, 1, 2);

        Label housePostalLabel = new Label("Enter Postal code:");
        TextField housePostalField = new TextField();
        houseGrid.add(housePostalLabel, 0, 3);
        houseGrid.add(housePostalField, 1, 3);

        Label houseCountryLabel = new Label("Enter Country:");
        TextField houseCountryField = new TextField();
        houseGrid.add(houseCountryLabel, 0, 4);
        houseGrid.add(houseCountryField, 1, 4);

        Label housenoOfbedroomsLabel = new Label("Enter number of bedrooms:");
        TextField housenoOfbedroomsField = new TextField();
        houseGrid.add(housenoOfbedroomsLabel, 0, 6);
        houseGrid.add(housenoOfbedroomsField, 1, 6);

        Label housenoOfbathroomsLabel = new Label("Enter number of bathrooms:");
        TextField housenoOfbathroomsField = new TextField();
        houseGrid.add(housenoOfbathroomsLabel, 0, 7);
        houseGrid.add(housenoOfbathroomsField, 1, 7);

        Label housesquarefootLabel = new Label("Enter number of Squarefoot:");
        TextField housesquarefootField = new TextField();
        houseGrid.add(housesquarefootLabel, 0, 8);
        houseGrid.add(housesquarefootField, 1, 8);

        Button houseSubmitButton = new Button("Submit");
        houseGrid.add(houseSubmitButton, 1, 9);

        // Create the modal window
        Stage houseModal = new Stage();
        houseModal.initModality(Modality.APPLICATION_MODAL);
        houseModal.initOwner(primaryStage);
        houseModal.setTitle("House details");
        houseModal.setScene(new Scene(houseGrid, 400, 500));

        // Show the modal window when the "Open" menu item is clicked
        menuItem3.setOnAction(event -> {
            houseModal.showAndWait();
        });

        houseSubmitButton.setOnAction(event -> {
            new Thread(() -> {
                String streetName =houseStreetField.getText();
                String plotNumber =housePlotField.getText();
                String city = houseCityField.getText();
                String postalCode =housePostalField.getText();
                String country =houseCountryField.getText();
                int noOfbedrooms =Integer.valueOf(housenoOfbedroomsField.getText());
                int noOfbathrooms =Integer.valueOf(housenoOfbathroomsField.getText());
                double squareFoot =Double.valueOf(housesquarefootField.getText());

                model.property.Property apt = new HouseModel(streetName,plotNumber,city,postalCode,country,noOfbedrooms,noOfbathrooms,squareFoot);
                pc.addHouse(apt);


                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        plotField.clear();
                        streetField.clear();
                        cityField.clear();
                        postalField.clear();
                        countryField.clear();
                        noOfbathroomsField.clear();
                        noOfbedroomsField.clear();
                        squarefootField.clear();

                        updatePropertyView();
                        propertyView.refresh();
                        houseModal.close();

                        showSuccessAlert("Property Added Successfully",apt.toString());
                    }
                });
            }).start();
        });


        //Rent a property
        GridPane rentAPropertyGrid = new GridPane();
        rentAPropertyGrid.setHgap(10);
        rentAPropertyGrid.setVgap(10);
        rentAPropertyGrid.setPadding(new Insets(10, 10, 10, 10));


        Label RentPropertyLabel = new Label("Choose type of property:");
        ComboBox chooseProperty = new ComboBox();
        chooseProperty.getItems().add("Apartment");
        chooseProperty.getItems().add("Condo");
        chooseProperty.getItems().add("House");
        rentAPropertyGrid.add(RentPropertyLabel,0,0);
        rentAPropertyGrid.add(chooseProperty,1,0);

        Label propertyIDLabel = new Label("Enter Property ID:");
        TextField propertyIDField = new TextField();
        rentAPropertyGrid.add(propertyIDLabel, 0, 1);
        rentAPropertyGrid.add(propertyIDField, 1, 1);

        Label tenantIDLabel = new Label("Enter Tenant ID:");
        TextField tenantIDField = new TextField();
        rentAPropertyGrid.add(tenantIDLabel, 0, 2);
        rentAPropertyGrid.add(tenantIDField, 1, 2);

        Label startDateLabel = new Label("Enter Start date:");
        TextField startDateField = new TextField();
        rentAPropertyGrid.add(startDateLabel, 0, 3);
        rentAPropertyGrid.add(startDateField, 1, 3);

        Label endDateLabel = new Label("Enter End Date:");
        TextField endDateField = new TextField();
        rentAPropertyGrid.add(endDateLabel, 0, 4);
        rentAPropertyGrid.add(endDateField, 1, 4);

        Label rentAmountLabel = new Label("Enter Rent amount:");
        TextField rentAmountField = new TextField();
        rentAPropertyGrid.add(rentAmountLabel, 0, 5);
        rentAPropertyGrid.add(rentAmountField, 1, 5);


        Button submitLease = new Button("Submit");
        rentAPropertyGrid.add(submitLease, 1, 6);

        // Create the modal window
        Stage rentAPropModal = new Stage();
        rentAPropModal.initModality(Modality.APPLICATION_MODAL);
        rentAPropModal.initOwner(primaryStage);
        rentAPropModal.setTitle("Add Lease Details");
        rentAPropModal.setScene(new Scene(rentAPropertyGrid, 400, 500));

        // Show the modal window when the "Open" menu item is clicked
        menuItem4.setOnAction(event -> {
            rentAPropModal.showAndWait();
        });
        //when we click submit button for apartment form
        submitLease.setOnAction(event -> {
           // int selectedIndex = chooseProperty.getSelectionModel().getSelectedIndex();
            new Thread(() -> {
                Object selectedItem = chooseProperty.getSelectionModel().getSelectedItem();
                String propertyType = (String) selectedItem;
                String propertyID =propertyIDField.getText();
                String tenantID =tenantIDField.getText();
                String sDate =startDateField.getText();
                Calendar startDate = CustomDate.getDate(sDate);
                String eDate =endDateField.getText();
                Calendar endDate = CustomDate.getDate(eDate);

                String propertyTypeCondensed = null;
                if(propertyType == "Apartment") {
                    propertyTypeCondensed = "APT";
                }
                else if(propertyType == "Condo") {
                    propertyTypeCondensed = "CON";
                }
                else if(propertyType == "House") {
                    propertyTypeCondensed = "HOU";
                }

                double amount = Double.parseDouble(rentAmountField.getText());


                if(pc.isRentedOrNot(propertyTypeCondensed,propertyID)) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            alert.setHeaderText("This property is already rented. Do you want to get notified when it is vacant?");
                            alert.setContentText("You will receive notifications");

                            ButtonType result = alert.showAndWait().get();
                            if (result == ButtonType.OK){
                                pc.addTenantAsObserver(propertyID, tenantID);
                                System.out.println(tenantID + " added as Observer");
                                showSuccessAlert("Tenant added as observer : ",tenantID);
                            } else {
                                //nothing
                            }
                        }
                    });
                }
                else {
                    LeaseModel newLease= new LeaseModel(propertyID,tenantID,startDate,endDate,amount);

                    pc.rentProperty(propertyTypeCondensed,newLease.getPropertyID(), newLease.getTenantID());
                    tc.addLeaseToTenant(newLease);
                    lc.addLease(newLease);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showSuccessAlert("Lease Added Successfully",newLease.toString());
                            propertyView.refresh();
                        }
                    });
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        propertyIDField.clear();
                        tenantIDField.clear();
                        startDateField.clear();
                        endDateField.clear();
                        rentAmountField.clear();

                        updateLeaseView();
                        leaseView.refresh();
                        rentAPropModal.close();
                    }
                });
            }).start();
        });



        //Terminate Lease
        GridPane terminateLeaseGrid = new GridPane();
        terminateLeaseGrid.setHgap(10);
        terminateLeaseGrid.setVgap(10);
        terminateLeaseGrid.setPadding(new Insets(10, 10, 10, 10));



        Label termLeaseIDLabel = new Label("Enter Lease ID:");
        TextField termLeaseIDField = new TextField();
        terminateLeaseGrid.add(termLeaseIDLabel, 0, 0);
        terminateLeaseGrid.add(termLeaseIDField, 1, 0);

        Button submitTermLease = new Button("Submit");
        terminateLeaseGrid.add(submitTermLease, 1, 6);

        // Create the modal window
        Stage termLeaseModal = new Stage();
        termLeaseModal.initModality(Modality.APPLICATION_MODAL);
        termLeaseModal.initOwner(primaryStage);
        termLeaseModal.setTitle("Terminate a lease");
        termLeaseModal.setScene(new Scene(terminateLeaseGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem6.setOnAction(event -> {
            termLeaseModal.showAndWait();
        });
        //when we click submit button for apartment form
        submitTermLease.setOnAction(event -> {
            new Thread(() -> {
                String leaseID =termLeaseIDField.getText();

                LeaseModel oldLease = lc.removeLease(leaseID);
                tc.removeLeaseFromTenant(oldLease);
                pc.vacantProperty(oldLease.getPropertyID());

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        termLeaseIDField.clear();

                        updateLeaseView();
                        leaseView.refresh();

                        termLeaseModal.close();

                        showSuccessAlert("Lease Terminated Successfully",oldLease.toString());
                    }
                });
            }).start();
        });


        //Show Interested Property
        GridPane showInterestedPropGrid = new GridPane();
        showInterestedPropGrid.setHgap(10);
        showInterestedPropGrid.setVgap(10);
        showInterestedPropGrid.setPadding(new Insets(10, 10, 10, 10));



        Label showInterestedPropTenantIDLabel = new Label("Enter Tenant ID:");
        TextField showInterestedPropTenantIDField = new TextField();
        showInterestedPropGrid.add(showInterestedPropTenantIDLabel, 0, 0);
        showInterestedPropGrid.add(showInterestedPropTenantIDField, 1, 0);

        Button subInterestedProp = new Button("Submit");
        showInterestedPropGrid.add(subInterestedProp, 1, 3);

        // Create the modal window
        Stage interestedPropModal = new Stage();
        interestedPropModal.initModality(Modality.APPLICATION_MODAL);
        interestedPropModal.initOwner(primaryStage);
        interestedPropModal.setTitle("Interested Properties");
        interestedPropModal.setScene(new Scene(showInterestedPropGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem8.setOnAction(event -> {
            interestedPropModal.showAndWait();
        });
        //when we click submit button for apartment form
        subInterestedProp.setOnAction(event -> {
            new Thread(() -> {
                String tenantID =showInterestedPropTenantIDField.getText();
                ArrayList<String> iProperties=  tc.getInterestedProperties(tenantID);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        termLeaseIDField.clear();

                        Stage showProp = new Stage();
                        showProp.initModality(Modality.APPLICATION_MODAL);
                        showProp.initOwner(primaryStage);
                        showProp.setTitle("Display Interested Leases");

                        ListView listView = new ListView();
                        listView.setMinSize(400,400);
                        Label error = new Label("Oops ! Its empty here !");
                        error.setMinSize(400,400);
                        error.setPadding(new Insets(80));
                        listView.setPlaceholder(error);

                        for (String property:iProperties
                        ) {
                            listView.getItems().add(property);
                        }

                        HBox hbox = new HBox(listView);

                        Scene scene = new Scene(hbox, 400, 400);
                        showProp.setScene(scene);
                        showProp.show();
                    }
                });
            }).start();
        });

        

        //Show Notification
        GridPane showNotificationGrid = new GridPane();
        showNotificationGrid.setHgap(10);
        showNotificationGrid.setVgap(10);
        showNotificationGrid.setPadding(new Insets(10, 10, 10, 10));



        Label showNotificationTenantIDLabel = new Label("Enter Tenant ID:");
        TextField showNotificationTenantIDField = new TextField();
        showNotificationGrid.add(showNotificationTenantIDLabel, 0, 0);
        showNotificationGrid.add(showNotificationTenantIDField, 1, 0);

        Button showNotifProp = new Button("Submit");
        showNotificationGrid.add(showNotifProp, 1, 3);

        // Create the modal window
        Stage notificationModal = new Stage();
        notificationModal.initModality(Modality.APPLICATION_MODAL);
        notificationModal.initOwner(primaryStage);
        notificationModal.setTitle("Notifications");
        notificationModal.setScene(new Scene(showNotificationGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem9.setOnAction(event -> {
            notificationModal.showAndWait();
        });
        //when we click submit button for apartment form
        showNotifProp.setOnAction(event -> {
            new Thread(() -> {
                String tenantID =showNotificationTenantIDField.getText();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        termLeaseIDField.clear();
                        Stage showProp = new Stage();
                        showProp.initModality(Modality.APPLICATION_MODAL);
                        showProp.initOwner(primaryStage);
                        showProp.setTitle("Display Notifications");

                        ListView listView = new ListView();
                        listView.setMinSize(400,400);

                        Label error = new Label("Oops ! Its empty here !");
                        error.setMinSize(400,400);
                        error.setPadding(new Insets(80));
                        listView.setPlaceholder(error);

                        ArrayList<String> iNotifications=  tc.getNotificationList(tenantID);
                        for (String n:iNotifications
                        ) {
                            listView.getItems().add(n);
                        }

                        HBox hbox = new HBox(listView);

                        Scene scene = new Scene(hbox, 400, 400);
                        showProp.setScene(scene);
                        showProp.show();
                    }
                });
            }).start();
        });






        //Tableview for Property
//        propertyView = new TableView();
//
//        TableColumn<Property, String> column10 =
//                new TableColumn<>("Id");
//        column10.setCellValueFactory(
//                new PropertyValueFactory<>("id"));
//
//
//        TableColumn<Property, String> column1 =
//                new TableColumn<>("Address");
//        column1.setCellValueFactory(
//                new PropertyValueFactory<>("address"));
//
//        TableColumn<Property, String> column7 =
//                new TableColumn<>("Number of bedrooms");
//
//        column7.setCellValueFactory(
//                new PropertyValueFactory<>("numberOfBedroom"));
//
//        TableColumn<Property, String> column8 =
//                new TableColumn<>("Number of bathrooms");
//
//        column8.setCellValueFactory(
//                new PropertyValueFactory<>("numberOfBathroom"));
//
//        TableColumn<Property, String> column9 =
//                new TableColumn<>("Square Foot");
//
//        column9.setCellValueFactory(
//                new PropertyValueFactory<>("squareFoot"));
//
//        column10.setPrefWidth(100);
//        column1.setPrefWidth(500);
//        column7.setPrefWidth(200);
//        column8.setPrefWidth(200);
//        column9.setPrefWidth(150);
////        column10.setPrefWidth(150);
//
//        propertyView.getColumns().add(column10);
//        propertyView.getColumns().add(column1);
//
//        propertyView.getColumns().add(column7);
//        propertyView.getColumns().add(column8);
//        propertyView.getColumns().add(column9);





        TabPane tabPane = new TabPane();
        Tab propertyTab = new Tab("Properties");
        Tab tenantTab = new Tab("Tenant");
        Tab leasesTab=new Tab("Lease");

        propertyView = PropertyUI.loadTable(propertyView);
        propertyTab.setContent(propertyView);
        tenantView = TenantUI.loadTable(tenantView);
        tenantTab.setContent(tenantView);
        leaseView = LeaseUI.loadTable(leaseView);
        leasesTab.setContent(leaseView);

        propertyTab.setClosable(false);
        tenantTab.setClosable(false);
        leasesTab.setClosable(false);


//        Tab tab3 = new Tab("Leases");
//        tab3.setContent(tableView);

        tabPane.getTabs().addAll(propertyTab,tenantTab,leasesTab);


        VBox vBox = new VBox();
      vBox.getChildren().addAll(menuBar,tabPane);


        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void updatePropertyView() {
        ArrayList<model.property.Property> allProperties = pc.getAllProperties();

        propertyView.getItems().clear();

        for(model.property.Property p : allProperties){
            propertyView.getItems().add(p);}
    }

    public static void updateTenantView() {
        ArrayList<TenantModel> allTenants = tc.getAllTenants();

        tenantView.getItems().clear();

        for(TenantModel p : allTenants){
            tenantView.getItems().add(p);}

        tenantView.sort();
    }

    public static void updateLeaseView() {
        ArrayList<LeaseModel> alLeases = lc.getAllLeases();

        leaseView.getItems().clear();

        for(LeaseModel p : alLeases){
            leaseView.getItems().add(p);}

        leaseView.sort();
    }

    public static void showSuccessAlert(String header,String message){
        Platform.runLater(()->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(header);
            alert.setContentText(message);
            alert.showAndWait();

        });

    }

    public static void showFailureAlert(String header,String message){
        Platform.runLater(()->{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure");
            alert.setHeaderText(header);
            alert.setContentText(message);
            alert.showAndWait();
        });

    }
}



