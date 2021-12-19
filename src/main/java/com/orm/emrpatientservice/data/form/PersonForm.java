package com.orm.emrpatientservice.data.form;

import javax.validation.constraints.NotNull;

public class PersonForm {
    private String title;
    @NotNull(message = "First name cannot be blank")
    private String firstName;
    @NotNull(message = "Last name cannot be blank")
    private String lastName;
    private String middleName;
    private String email;
    @NotNull(message = "Phone number cannot be blank")
    private String phoneNumber;

    public PersonForm(String title, @NotNull(message = "First name cannot be blank") String firstName, @NotNull(message = "Last name cannot be blank") String lastName, String middleName, String email, @NotNull(message = "Phone number cannot be blank") String phoneNumber) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public PersonForm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
