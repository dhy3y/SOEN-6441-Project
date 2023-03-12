package model.property;

public class HouseModel extends Property{
    private int numberOfBedroom;
    private int numberOfBathroom;
    private double squareFoot;

    public HouseModel(String streetName, String plotNumber, String city, String postalCode, String country,
            int numberOfBedroom, int numberOfBathroom, double squareFoot) {
        super(streetName, plotNumber, city, postalCode, country);
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfBathroom = numberOfBathroom;
        this.squareFoot = squareFoot;
    }

    public HouseModel(String plotNumber,String streetName, String city, String postalCode, String country) {
        super(streetName, plotNumber, city, postalCode, country);
    }

    @Override
    String generateAddress() {
        return  plotNumber +", "+streetName+", " +city+", "+postalCode+", "+country;
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

    @Override
    public String toString() {
        return "Plot number : " + plotNumber + 
            "\nStreet Name : " + streetName +
            "\nCity : " + city +
            "\nPostal Code : " + postalCode +
            "\nCountry : " + country +
                "\nRented : " + rented +
            "\nBedrooms : " + numberOfBedroom +
            "\nBathrooms : " + numberOfBathroom +
            "\nSquare foot : " + squareFoot + "\n";
    }
}
