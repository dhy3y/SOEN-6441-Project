package view.UI;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import set.Property;

public class PropertyUI {

    public static TableView loadTable(TableView propertyView) {
        propertyView = new TableView();

        TableColumn<Property, String> column10 =
                new TableColumn<>("Id");
        column10.setCellValueFactory(
                new PropertyValueFactory<>("id"));


        TableColumn<Property, String> column1 =
                new TableColumn<>("Address");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("address"));

        TableColumn<Property, String> column7 =
                new TableColumn<>("Number of bedrooms");

        column7.setCellValueFactory(
                new PropertyValueFactory<>("numberOfBedroom"));

        TableColumn<Property, String> column8 =
                new TableColumn<>("Number of bathrooms");

        column8.setCellValueFactory(
                new PropertyValueFactory<>("numberOfBathroom"));

        TableColumn<Property, String> column9 =
                new TableColumn<>("Square Foot");

        column9.setCellValueFactory(
                new PropertyValueFactory<>("squareFoot"));

        TableColumn<Property, String> column11 =
                new TableColumn<>("Rented or not");

        column11.setCellValueFactory(
                new PropertyValueFactory<>("rented"));

        column10.setPrefWidth(100);
        column1.setPrefWidth(500);
        column7.setPrefWidth(200);
        column8.setPrefWidth(200);
        column9.setPrefWidth(150);
        column11.setPrefWidth(150);

        propertyView.getColumns().add(column10);
        propertyView.getColumns().add(column1);

        propertyView.getColumns().add(column7);
        propertyView.getColumns().add(column8);
        propertyView.getColumns().add(column9);
        propertyView.getColumns().add(column11);

        return propertyView;
    }

    public static void onCallEventListener() {

    }

    public static void addApartment() {

    }

    public static void addCondo() {

    }

    public static void addHouse() {

    }

    public static void rentAProperty() {

    }

}
