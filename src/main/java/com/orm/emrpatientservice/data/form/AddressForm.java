package com.orm.emrpatientservice.data.form;

public class AddressForm {
    private String street;
    private String city;
    private String state;

    public AddressForm(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public AddressForm() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
