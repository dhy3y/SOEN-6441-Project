package model.property;

import java.util.ArrayList;

public abstract class Property {

    protected String streetName;
    protected String plotNumber;
    protected String city;
    protected String postalCode;
    protected String country;
    protected Boolean rented;
    protected ArrayList<String> interestedTenants;



    public Property(String streetName, String plotNumber, String city, String postalCode, String country) {
        this.streetName = streetName;
        this.plotNumber = plotNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.rented=Boolean.FALSE;
        this.interestedTenants = new ArrayList<String>();
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


    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public ArrayList<String> getInterestedTenants() {
        return interestedTenants;
    }

    public void attachInterestedTenants(String tenant) {
        interestedTenants.add(tenant);
    }

    public void detachInterestedTenant(String tenant) {
        interestedTenants.remove(tenant);
    }

    abstract String generateAddress();
}