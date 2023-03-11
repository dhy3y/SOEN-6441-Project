package model.property;

public class CondoModel extends Property{
    private String unitNumber;
    private String condoID;
    private int numberOfBedroom;
    private int numberOfBathroom;

    private double squareFoot;

    public CondoModel( String condoID, String unitNumber,String plotNumber,String streetName, String city, String postalCode, String country, int numberOfBedroom, int numberOfBathroom, double squareFoot) {
        super(streetName, plotNumber, city, postalCode, country);
        this.unitNumber = unitNumber;
        this.condoID = condoID;
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfBathroom = numberOfBathroom;
        this.squareFoot = squareFoot;
    }

    @Override
    String generateAddress() {
        return unitNumber+"-"+ plotNumber +", "+streetName+", " +city+", "+postalCode+", "+country;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getCondoID() {
        return condoID;
    }

    public void setCondoID(String condoID) {
        this.condoID = condoID;
    }

    public int getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(int numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public int getNumberOfBathroom() {
        return numberOfBathroom;
    }

    public void setNumberOfBathroom(int numberOfBathroom) {
        this.numberOfBathroom = numberOfBathroom;
    }

    public double getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(double squareFoot) {
        this.squareFoot = squareFoot;
    }
}

