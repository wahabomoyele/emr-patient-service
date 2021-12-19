package com.orm.emrpatientservice.data.entity;

import com.orm.emrpatientservice.data.constant.Title;
import com.orm.emrpatientservice.data.form.PersonForm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.StringUtils.*;

@MappedSuperclass
public class Person extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Title title;
    @NotNull(message = "First name cannot be blank")
    private String firstName;
    @NotNull(message = "Last name cannot be blank")
    private String lastName;
    private String middleName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    @NotNull(message = "Phone number cannot be blank")
    private String phoneNumber;


    public static void build(PersonForm form, Person person) {
        person.setFirstName(capitalize(lowerCase(trim(form.getFirstName()))));
        person.setLastName(capitalize(lowerCase(trim(form.getLastName()))));
        person.setMiddleName(capitalize(lowerCase(trim(form.getMiddleName()))));
        person.setEmail(lowerCase(trim(form.getEmail())));
        person.setPhoneNumber(upperCase(trim(form.getPhoneNumber())));
        person.setTitle(Title.findByName(form.getTitle()));
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
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
