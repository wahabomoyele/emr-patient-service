package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.Util.TestData;
import com.orm.emrpatientservice.data.constant.Title;
import com.orm.emrpatientservice.data.entity.Address;
import com.orm.emrpatientservice.data.entity.NextOfKin;
import com.orm.emrpatientservice.data.form.AddressForm;
import com.orm.emrpatientservice.data.repository.AddressRepository;
import com.orm.emrpatientservice.data.repository.NextOfKinRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientContactInfoUnitTest {
    @Mock
    AddressRepository addressRepository;
    @Mock
    NextOfKinRepository nextOfKinRepository;
    @InjectMocks
    PatientContactInfoService patientContactInfoService;

    @BeforeEach
    void beforeAll() {
        patientContactInfoService = new PatientContactInfoService(addressRepository, nextOfKinRepository);
    }

    @Test
    void saveAddress() {
        TestData testData = new TestData();
        when(addressRepository.save(any(Address.class))).thenAnswer(f -> f.getArguments()[0]);
        Address address = patientContactInfoService.saveAddress(testData.addressForm, null);
        assertNotNull(address);
        assertEquals(address.getStateName(), address.getState().getName());

        AddressForm a = new AddressForm("BambuLa STREET", "Some City", "NG_OY");
        address = patientContactInfoService.saveAddress(a, address);
        assertEquals(address.getStreet(), "Bambula street");
    }

    @Test
    void saveNextOfKin() {
        TestData testData = new TestData();
        when(nextOfKinRepository.save(any(NextOfKin.class))).thenAnswer(f -> f.getArguments()[0]);
        NextOfKin nextOfKin = patientContactInfoService.saveNextOfKin(testData.nextOfKinForm, null);
        assertNotNull(nextOfKin);
        assertEquals(nextOfKin.getLastName(), "Badmus");
        assertNull(nextOfKin.getMiddleName());
        assertEquals(nextOfKin.getTitle(), Title.MR);
    }
}
