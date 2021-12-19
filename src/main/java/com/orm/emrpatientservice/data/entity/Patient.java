package com.orm.emrpatientservice.data.entity;

import com.orm.emrpatientservice.business.service.Utilities;
import com.orm.emrpatientservice.data.constant.Sex;
import com.orm.emrpatientservice.data.constant.Title;
import com.orm.emrpatientservice.data.form.PatientForm;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.*;

@Entity
public class Patient extends Person {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();
    @NotNull(message = "Date of birth cannot be blank")
    private LocalDate dateOfBirth;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @ManyToMany
    @JoinColumn
    private Set<PatientGroup> groups = new HashSet<>();

    public static void build(PatientForm form, Patient patient) {
        Person.build(form, patient);
        patient.setSex(Sex.findByName(form.getSex()));
        patient.setDateOfBirth(Utilities.parseDate(form.getDateOfBirth()));
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<PatientGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<PatientGroup> patientGroups) {
        this.groups = patientGroups;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
