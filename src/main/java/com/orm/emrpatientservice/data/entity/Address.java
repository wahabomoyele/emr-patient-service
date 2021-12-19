package com.orm.emrpatientservice.data.entity;

import com.orm.emrpatientservice.data.constant.State;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private State state;
    private String stateName;

    public Address(@NotNull String street, @NotNull String city, @NotNull State state) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.stateName = state.getName();
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
