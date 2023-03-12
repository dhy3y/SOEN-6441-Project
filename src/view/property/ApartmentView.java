package view.property;
import model.property.*;

public class ApartmentView {

    public Property getApartmentDetails() {
        System.out.println(); //add
        Property p1 = new ApartmentModel("A1", "801", "1975", "de Maisoneve", "Montreal", "h3h1k4", "Canada", 2,1, 1000);
        return p1;
    }

    public void printApartmentDetails(Property p1) {

        System.out.println("This is an apartment" );
    }
}
