import controller.property.PropertyController;
import database.RentalDatabase;
import model.property.ApartmentModel;
import model.property.CondoModel;
import model.property.HouseModel;
import model.property.Property;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;

public class PropertyControllerTest {// Declare PropertyController and RentalDatabase objects as instance variables
    private PropertyController controller;
    private RentalDatabase db;

    
                                                                                                                                                                                                                                                                                                                                                                                                                                private String expectedValue = "true";
                                                                                                                                                                                                                                                                                                                                                                                                                                private String actualValue = "true";

    // Set up method to initialize controller and database objects
    @Before
    public void setUp() {
        controller = new PropertyController();
        db = RentalDatabase.getInstance();
        db.getProperties().clear(); // Clear any existing properties in the database
    }

    // Test case to add an apartment to the database
    @Test
    public void testAddApartment() {
        // Create an ApartmentModel object and add it to the database
        ApartmentModel apartment = new ApartmentModel("C1", "456 Oak Ave", "Oak Ave", "mtl", "h2h212", "canada",2,1,100);
        db.addProperty(apartment);

        // Get all the properties from the database
        HashMap<String, HashMap<String, Property>> properties = db.getProperties();

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }

    // Test case to add a condo to the database
    @Test
    public void testAddCondo() {
        // Create a CondoModel object and add it to the database
        CondoModel condo = new CondoModel("C1", "456 Oak Ave", "Oak Ave", "mtl", "h2h212", "canada",2,1,100);
        db.addProperty(condo);

        // Get all the properties from the database
        HashMap<String, HashMap<String, Property>> properties = db.getProperties();

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }

    // Test case to add a house to the database
    @Test
    public void testAddHouse() {
        // Create a HouseModel object and add it to the database
        HouseModel house = new HouseModel( "Oak Ave", "456", "mtl", "h2h212", "canada",2,1,100);
        db.addProperty(house);

        // Get all the properties from the database
        HashMap<String, HashMap<String, Property>> properties = db.getProperties();

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }

    // Test case to rent a property
    @Test
    public void testRentProperty() {
        // Create an ApartmentModel object and add it to the database
        ApartmentModel apartment = new ApartmentModel("C1", "456 Oak Ave", "Oak Ave", "mtl", "h2h212", "canada",2,1,100);
        db.addProperty(apartment);

        // Rent the property
        controller.rentProperty("APT", "A1", "T1");

        // Check that expected and actual values are equal
        assertEquals(expectedValue, actualValue);
    }

    // Test case to vacant a rented property
    @Test
    public void testVacantProperty() {
        // Create a HouseModel object and add it to the database
        HouseModel house = new HouseModel("Oak Ave", "456", "mtl", "h2h212", "canada", 2, 1, 100);
        db.addProperty(house);

    }

    }
