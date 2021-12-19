package com.orm.emrpatientservice.data.form;

import javax.validation.constraints.NotNull;

public class NextOfKinForm extends PersonForm{
    private String address;

    public NextOfKinForm(String title, @NotNull(message = "First name cannot be blank") String firstName, @NotNull(message = "Last name cannot be blank") String lastName, String middleName, String email, @NotNull(message = "Phone number cannot be blank") String phoneNumber, String address) {
        super(title, firstName, lastName, middleName, email, phoneNumber);
        this.address = address;
    }

    public NextOfKinForm() {}

    public NextOfKinForm(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
