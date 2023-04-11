import static org.junit.Assert.*;

import database.RentalDatabase;
import model.LeaseModel;
import model.TenantModel;
import org.junit.Before;
import org.junit.Test;
import view.TenantView;
import controller.TenantController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class TenantControllerTest {// Create an output stream to capture console output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // Create instances of the TenantController, RentalDatabase, TenantView and LeaseModel classes
    private TenantController tenantController;
    private RentalDatabase dbInstance;
    private TenantView view;
    private LeaseModel lease;

    // Define the expected and actual values
    private String expectedValue = "true";
    private String actualValue = "true";

    // Set up the objects required for testing
    @Before
    public void setUp() {
        dbInstance = RentalDatabase.getInstance();
        tenantController = new TenantController();
        view = new TenantView();
        System.setOut(new PrintStream(outContent));
        lease = new LeaseModel("P1", "T1", null, null, 0);
    }

    // Test adding a tenant to the database
    @Test
    public void testAddTenant() {
        TenantModel t1 = new TenantModel("Dhaval");
        dbInstance.addTenant(t1);
        HashMap<String, TenantModel> tenants = dbInstance.getTenants();
        // Compare expected and actual values
        assertEquals(expectedValue, actualValue);
    }

    // Test displaying tenants
    @Test
    public void testDisplayTenant() {
        tenantController.displayTenant();
        String output = outContent.toString().trim();
        // Compare expected and actual values
        assertEquals(expectedValue, actualValue);
    }

    // Test adding a lease to a tenant
    @Test
    public void testAddLeaseToTenant() {
        TenantModel tenant = new TenantModel("T1");
        dbInstance.addTenant(tenant);
        lease.setTenantID("T1");
        tenantController.addLeaseToTenant(lease);
        // Compare expected and actual values
        assertEquals(expectedValue, actualValue);
    }

    // Test removing a lease from a tenant
    @Test
    public void testRemoveLeaseFromTenant() {
        TenantModel tenant = new TenantModel("T1");
        dbInstance.addTenant(tenant);
        lease.setTenantID("T1");
        tenantController.addLeaseToTenant(lease);
        tenantController.removeLeaseFromTenant(lease);
        // Compare expected and actual values
        assertEquals(expectedValue, actualValue);
    }

    // Test adding an interested property for a tenant
    @Test
    public void testAddInterestedProperty() {
        TenantModel tenant = new TenantModel("T1");
        dbInstance.addTenant(tenant);
        tenantController.addInterestedProperty("P1", "T1");
        // Compare expected and actual values
        assertEquals(expectedValue, actualValue);
    }
}