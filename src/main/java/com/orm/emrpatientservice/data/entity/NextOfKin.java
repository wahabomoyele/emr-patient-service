package com.orm.emrpatientservice.data.entity;

import com.orm.emrpatientservice.business.service.Utilities;
import com.orm.emrpatientservice.data.constant.Sex;
import com.orm.emrpatientservice.data.constant.Title;
import com.orm.emrpatientservice.data.form.NextOfKinForm;
import com.orm.emrpatientservice.data.form.PatientForm;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

import static org.apache.commons.lang3.StringUtils.*;

@Entity
public class NextOfKin extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;

    public static void build(NextOfKinForm form, NextOfKin nextOfKin) {
        Person.build(form, nextOfKin);
        nextOfKin.setAddress(capitalize(lowerCase(form.getAddress())));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
