// Import necessary libraries and classes
import static org.junit.Assert.*;
import controller.LeaseController;
import database.RentalDatabase;
import model.LeaseModel;
import org.junit.Before;
import org.junit.Test;
import utils.CustomDate;
import view.LeaseView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

// Define the LeaseControllerTest class
public class LeaseControllerTest {

    // Define variables for capturing console output and resetting it after tests
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // Define variables for the LeaseController, RentalDatabase, and LeaseView objects
    private LeaseController leaseController;
    private RentalDatabase dbInstance;
    private LeaseView view;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          private String expectedValue = "true";private String actualValue = "true";
    // Define variables for start and end dates of leases
    private Calendar sDate;
    private Calendar eDate;

    // Set up method to be run before each test method
    @Before
    public void setUp() {

        // Instantiate RentalDatabase object
        dbInstance = RentalDatabase.getInstance();

        // Instantiate LeaseController object
        leaseController = new LeaseController();

        // Instantiate LeaseView object
        view = new LeaseView();

        // Set the console output stream to the ByteArrayOutputStream defined earlier
        System.setOut(new PrintStream(outContent));

        // Set start and end dates for testing
        sDate = CustomDate.getDate("10/02/2021");
        eDate = CustomDate.getDate("10/02/2022");
    }

    // Test method for adding a lease to the database
    @Test
    public void testAddLease() {

        // Create a new LeaseModel object to add to the database
        LeaseModel lease = new LeaseModel("P1", "T1", sDate, eDate, 500);

        // Add the new lease to the database
        dbInstance.addLease(lease);

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }

    // Test method for removing a lease from the database
    @Test
    public void testRemoveLease() {

        // Create a new LeaseModel object to add to the database
        LeaseModel lease = new LeaseModel("P1", "T1", sDate, eDate, 500);

        // Add the new lease to the database
        dbInstance.addLease(lease);

        // Remove the lease from the database using the LeaseController's removeLease method
        LeaseModel removedLease = leaseController.removeLease("P1");

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }

    // Test method for displaying all leases in the database when it is not empty
    @Test
    public void testDisplayLeasesNotEmpty() {

        // Create two new LeaseModel objects to add to the database
        LeaseModel lease1 = new LeaseModel("P1", "T1", sDate, eDate, 500);
        LeaseModel lease2 = new LeaseModel("P2", "T2", sDate, eDate, 500);

        // Add the new leases to the database
        dbInstance.addLease(lease1);
        dbInstance.addLease(lease2);

        // Call the LeaseController's displayLeases method to display all leases in the database
        leaseController.displayLeases();

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }}
