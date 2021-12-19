package com.orm.emrpatientservice.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orm.emrpatientservice.data.constant.BloodGroup;
import com.orm.emrpatientservice.data.form.ClinicalInfoForm;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class PatientClinicalInfo extends BaseEntity{
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private Patient patient;
    private Double weight;
    private Double height;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @Lob
    private String allergies;

    public static void build(ClinicalInfoForm form, PatientClinicalInfo info) {
        info.setWeight(form.getWeight());
        info.setHeight(form.getHeight());
        info.setBloodGroup(BloodGroup.findById(form.getBloodGroup()));
        info.setAllergies(form.getAllergies());
    }

    public static void build(ClinicalInfoForm form, PatientClinicalInfo info, Patient p) {
        PatientClinicalInfo.build(form, info);
        info.setId(p.getId());
        info.setPatient(p);
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
