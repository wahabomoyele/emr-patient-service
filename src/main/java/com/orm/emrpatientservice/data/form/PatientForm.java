package com.orm.emrpatientservice.data.form;

import com.orm.emrpatientservice.data.constant.Sex;
import com.orm.emrpatientservice.data.entity.PatientGroup;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PatientForm {
    private String title;
    @NotNull(message = "First name cannot be blank")
    private String firstName;
    @NotNull(message = "Last name cannot be blank")
    private String lastName;
    private String middleName;
    private String email;
    @NotNull(message = "Phone number cannot be blank")
    private String phoneNumber;
    @NotNull(message = "Date of birth cannot be blank")
    private String dateOfBirth;
    @NotNull
    private String sex;
    private Set<Long> groups = new HashSet<>();

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Long> getGroups() {
        return groups;
    }

    public void setGroups(Set<Long> groups) {
        this.groups = groups;
    }

    public PatientForm(String title, @NotNull(message = "First name cannot be blank") String firstName, @NotNull(message = "Last name cannot be blank") String lastName, String middleName, String email, @NotNull(message = "Phone number cannot be blank") String phoneNumber, @NotNull(message = "Date of birth cannot be blank") String dateOfBirth, @NotNull String sex, Set<Long> groups) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.groups = groups;
    }

    public PatientForm() {
    }
}
