package view.UI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.property.HouseModel;
import model.property.Property;

public class Demo extends Application {
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
        MenuItem menuItem5 = new MenuItem("Add Payment");
        MenuItem menuItem6 = new MenuItem("Change Property Status");
        MenuItem menuItem7 = new MenuItem("Terminate Lease");
        menu2.getItems().add(menuItem4);
        menu2.getItems().add(menuItem5);
        menu2.getItems().add(menuItem6);
        menu2.getItems().add(menuItem7);

        //Add Tenant
        Menu menu3 = new Menu("Tenant");
        MenuItem menuItem8 = new MenuItem("Show interested Property");
        MenuItem menuItem9 = new MenuItem("Show Notifications");
        MenuItem menuItem10= new MenuItem("Add Tenant");
        menu3.getItems().add(menuItem8);
        menu3.getItems().add(menuItem9);
        menu3.getItems().add(menuItem10);

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
        apartmentModal.setScene(new Scene(apartmentGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem1.setOnAction(event -> {
            apartmentModal.showAndWait();
        });
        //when we click submit button for apartment form
        submitButton.setOnAction(event -> {
            String apartmentNumber =apartmentField.getText();
            String plotNumber =plotField.getText();
            String streetNumber =streetField.getText();
            String city =cityField.getText();
            String postalCode =postalField.getText();
            String country =countryField.getText();
            int noOfbedrooms =Integer.valueOf(noOfbedroomsField.getText());
            int noOfbathrooms =Integer.valueOf(noOfbathroomsField.getText());
            double squareFoot =Double.valueOf(squarefootField.getText());
            apartmentField.clear();
            plotField.clear();
            streetField.clear();
            cityField.clear();
            postalField.clear();
            countryField.clear();
            noOfbathroomsField.clear();
            noOfbedroomsField.clear();
            squarefootField.clear();


        });

        //Condo details form
        GridPane condoGrid = new GridPane();
        condoGrid.setHgap(10);
        condoGrid.setVgap(10);
        condoGrid.setPadding(new Insets(10, 10, 10, 10));

        Label concdoUnitLabel = new Label("Enter Unit number:");
        TextField condoUnitField = new TextField();
        condoGrid.add(concdoUnitLabel, 0, 0);
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

        Button condoSubmitButton = new Button("Submit");
        condoGrid.add(condoSubmitButton, 1, 9);

        // Create the modal window
        Stage condoModal = new Stage();
        condoModal.initModality(Modality.APPLICATION_MODAL);
        condoModal.initOwner(primaryStage);
        condoModal.setTitle("Condo details");
        condoModal.setScene(new Scene(condoGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem2.setOnAction(event -> {
            condoModal.showAndWait();
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
        houseModal.setScene(new Scene(houseGrid, 400, 400));

        // Show the modal window when the "Open" menu item is clicked
        menuItem3.setOnAction(event -> {
            houseModal.showAndWait();
        });



        //Tableview
        TableView tableView = new TableView();
        TableView tableView2 = new TableView();

        TableColumn<Person, String> column1 =
                new TableColumn<>("First Name");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));


        TableColumn<Person, String> column2 =
                new TableColumn<>("Last Name");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.getItems().add(
                new Person("John", "Doe"));
        tableView.getItems().add(
                new Person("Jane", "Deer"));

        tableView2.getColumns().add(column1);
        tableView2.getColumns().add(column2);

        tableView2.getItems().add(
                new Person("John", "Doe"));
        tableView2.getItems().add(
                new Person("Jane", "Deer"));



        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Properties");
        tab1.setContent(tableView);

        Tab tab2 = new Tab("Tenants");
        tab2.setContent(tableView2);
//
//        Tab tab3 = new Tab("Leases");
//        tab3.setContent(tableView);

        tabPane.getTabs().addAll(tab1,tab2);


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
}



