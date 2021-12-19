package com.orm.emrpatientservice.Util;

import com.orm.emrpatientservice.data.constant.State;
import com.orm.emrpatientservice.data.entity.Address;
import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.form.AddressForm;
import com.orm.emrpatientservice.data.form.NextOfKinForm;
import com.orm.emrpatientservice.data.form.PatientForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class TestData {
    public final UUID uuid = UUID.randomUUID();
    public final PatientForm patientForm = new PatientForm("Mr", "Wahab", "Omoyele", "Akorede", "wahabomoyele@yahoo.com", "+2347068502356", "06/09/1990", "male", new HashSet<>(Arrays.asList(1L,2L)));
    public final AddressForm addressForm = new AddressForm("18B, Mayegun Street", "Abeokuta", "NG_OG");
    public final NextOfKinForm nextOfKinForm = new NextOfKinForm("mr", "samuel", "badmus", null, "samuelbadmus@gmail.com", "09037282618", "Olabode close, Lekki, Lagos");
    public final Address address = new Address("19B, Mayegun Street", "Abeokuta", State.NG_OG);
    public Patient patient = new Patient();
    public TestData() {
        Patient.build(patientForm, patient);
    }
}
