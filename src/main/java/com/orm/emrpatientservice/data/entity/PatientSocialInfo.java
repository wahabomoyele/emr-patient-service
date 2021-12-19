package com.orm.emrpatientservice.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orm.emrpatientservice.data.constant.*;
import com.orm.emrpatientservice.data.form.ClinicalInfoForm;
import com.orm.emrpatientservice.data.form.SocialInfoForm;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.*;

@Entity
public class PatientSocialInfo extends BaseEntity{
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private Patient patient;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    @Enumerated(EnumType.STRING)
    private Religion religion;
    @Enumerated(EnumType.STRING)
    private Language language;
    @Enumerated(EnumType.STRING)
    private Education education;
    private String tribe;


    public static void build(SocialInfoForm form, PatientSocialInfo info) {
        info.setMaritalStatus(MaritalStatus.findByName(form.getMaritalStatus()));
        info.setReligion(Religion.findByName(form.getReligion()));
        info.setLanguage(Language.findByName(form.getLanguage()));
        info.setEducation(Education.findByName(form.getEducation()));
        info.setTribe(capitalize(lowerCase(trim(form.getTribe()))));
    }

    public static void build(SocialInfoForm form, PatientSocialInfo info, Patient p) {
        PatientSocialInfo.build(form, info);
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }
}
