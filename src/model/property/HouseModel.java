package model.property;

public class HouseModel extends Property{
    private String houseID;
    private int numberOfBedroom;
    private int numberOfBathroom;
    private double squareFoot;

    public HouseModel(String houseID, String plotNumber,String streetNumber, String city, String postalCode, String country) {
        super(plotNumber, streetNumber, city, postalCode, country);
        this.houseID = houseID;
    }

    @Override
    String generateAddress() {
        return  plotNumber +", "+streetName+", " +city+", "+postalCode+", "+country;
    }

    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
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
