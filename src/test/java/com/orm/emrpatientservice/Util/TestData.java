package com.orm.emrpatientservice.Util;

import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.form.PatientForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class TestData {
    public final UUID uuid = UUID.randomUUID();
    public final PatientForm patientForm = new PatientForm("Mr", "Wahab", "Omoyele", "Akorede", "wahabomoyele@yahoo.com", "+2347068502356", "06/09/1990", "male", new HashSet<>(Arrays.asList(1L,2L)));
    public Patient patient;
    public TestData() {
        patient = Patient.build(patientForm, new Patient());
    }
}
