package com.orm.emrpatientservice.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class PatientContactInfo {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private Patient patient;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private NextOfKin nextOfKin;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Address address;


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

    public NextOfKin getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKin nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
