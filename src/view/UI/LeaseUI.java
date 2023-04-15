package view.UI;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.LeaseModel;

import java.util.Calendar;

public class LeaseUI {

    public static TableView loadTable(TableView leaseView) {
        //Add Lease table view
        leaseView = new TableView();

        TableColumn<LeaseModel, String> leaseColumn1 =
                new TableColumn<>("Tenant ID ");
        leaseColumn1.setCellValueFactory(
                new PropertyValueFactory<>("tenantID"));

        TableColumn<LeaseModel, String> leaseColumn5 =
                new TableColumn<>("Property ID ");
        leaseColumn5.setCellValueFactory(
                new PropertyValueFactory<>("propertyID"));

        TableColumn<LeaseModel, Calendar> leaseColumn2 =
                new TableColumn<>("Start Date");
        leaseColumn2.setCellValueFactory(
                new PropertyValueFactory<>("startDateInString"));

        TableColumn<LeaseModel, Calendar> leaseColumn3 =
                new TableColumn<>("End Date");
        leaseColumn3.setCellValueFactory(
                new PropertyValueFactory<>("endDateInString"));

        TableColumn<LeaseModel, String> leaseColumn4 =
                new TableColumn<>("Amount");
        leaseColumn4.setCellValueFactory(
                new PropertyValueFactory<>("amount"));

        leaseColumn1.setPrefWidth(150);
        leaseColumn2.setPrefWidth(150);
        leaseColumn3.setPrefWidth(150);
        leaseColumn4.setPrefWidth(150);


        leaseView.getColumns().add(leaseColumn5);
        leaseView.getColumns().add(leaseColumn1);
        leaseView.getColumns().add(leaseColumn2);
        leaseView.getColumns().add(leaseColumn3);
        leaseView.getColumns().add(leaseColumn4);
        leaseView.getSortOrder().add(leaseColumn1);

        return leaseView;
    }
}
