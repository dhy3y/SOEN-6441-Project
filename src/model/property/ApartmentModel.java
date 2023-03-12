package model.property;

public class ApartmentModel extends Property {

    private String apartmentNumber;
    private int numberOfBedroom;
    private int numberOfBathroom;
    private double squareFoot;

    public ApartmentModel(String apartmentNumber, String plotNumber,String streetName,  String city, String postalCode, String country, int numberOfBedroom, int numberOfBathroom, double squareFoot) {
        super(streetName, plotNumber, city, postalCode, country);
        this.apartmentNumber = apartmentNumber;
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfBathroom = numberOfBathroom;
        this.squareFoot = squareFoot;
    }


    @Override
    String generateAddress() {
        return apartmentNumber+"-"+ plotNumber +", "+streetName+", " +city+", "+postalCode+", "+country;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
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
         return "Apartment no : " + apartmentNumber +
            "\nPlot number : " + plotNumber + 
            "\nStreet Name : " + streetName +
            "\nCity : " + city +
            "\nPostal Code : " + postalCode +
            "\nCountry : " + country +
            "\nBedrooms : " + numberOfBedroom +
            "\nBathrooms : " + numberOfBathroom +
            "\nSquare foot : " + squareFoot + "\n";
    }
}
