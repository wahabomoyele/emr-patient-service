package com.orm.emrpatientservice.data.form;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class PatientForm extends PersonForm{

    @NotNull(message = "Date of birth cannot be blank")
    private String dateOfBirth;
    @NotNull
    private String sex;
    private Set<Long> groups = new HashSet<>();

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
        super(title, firstName, lastName, middleName, email, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.groups = groups;
    }

    public PatientForm() {
    }
}
