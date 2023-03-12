package model.property;

public abstract class Property {

    protected String streetName;
    protected String plotNumber;
    protected String city;
    protected String postalCode;
    protected String country;


    public Property(String streetName, String plotNumber, String city, String postalCode, String country) {
        this.streetName = streetName;
        this.plotNumber = plotNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    abstract String generateAddress();
}