package view.UI;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TenantModel;

public class TenantUI {

    public static TableView loadTable(TableView tenantView) {
        tenantView = new TableView();

        TableColumn<TenantModel, String> tenantColumn1 =
                new TableColumn<>("Tenant ID ");
        tenantColumn1.setCellValueFactory(
                new PropertyValueFactory<>("tenantID"));

        TableColumn<TenantModel, String> tenantColumn2 =
                new TableColumn<>("Tenant Name");
        tenantColumn2.setCellValueFactory(
                new PropertyValueFactory<>("tenantName"));



        tenantColumn1.setPrefWidth(200);
        tenantColumn2.setPrefWidth(150);



        tenantView.getColumns().add(tenantColumn1);
        tenantView.getColumns().add(tenantColumn2);
        tenantView.getSortOrder().add(tenantColumn1);

        return tenantView;
    }

    public static void onCallEventListener() {

    }

    public static void addTenant() {

    }

    public static void showInterestedProperty() {

    }

    public static void showNotifications() {

    }
}
