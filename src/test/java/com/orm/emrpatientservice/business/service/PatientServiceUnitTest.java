package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.Util.TestData;
import com.orm.emrpatientservice.business.exception.BadRequestException;
import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.form.Message;
import com.orm.emrpatientservice.data.form.PatientForm;
import com.orm.emrpatientservice.data.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Patient Service Test")
class PatientServiceUnitTest {
    @Mock
    PatientRepository patientRepository;
    @Mock
    PatientGroupService patientGroupService;
    @Mock
    EntryService entryService;
    @Mock
    PatientDetailsService patientDetailsService;

    @InjectMocks
    PatientService patientService;

    @BeforeEach
    void setUp() {
        patientService = new PatientService(patientRepository, patientGroupService, entryService, patientDetailsService);
    }

    @Test
    void getPatient() {
        TestData testData = new TestData();


        // Bad UUID string
        Exception exception = assertThrows(BadRequestException.class, () -> patientService.getPatient("bad-string"));
        assertNotNull(exception);
        assertTrue(exception.getLocalizedMessage().contains("Invalid"));

        when(patientRepository.findById(any(UUID.class))).thenReturn(Optional.of(testData.patient));
        Patient patient = patientService.getPatient(testData.uuid.toString());
        assertNotNull(patient.getId());
    }

    @Test
    void addPatient() {
        TestData testData = new TestData();

        // Good form
        when(patientRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(patientGroupService.findGroups(anySet())).thenReturn(new HashSet<>());
        when(patientRepository.save(any(Patient.class))).thenAnswer(f -> f.getArguments()[0]);
        Patient patient = patientService.addPatient(testData.patientForm);
        assertNotNull(patient);


        // Duplicate email address
        Patient savedPatient = new Patient();
        BeanUtils.copyProperties(testData.patient, savedPatient, "id");
        savedPatient.setId(UUID.randomUUID());
        when(patientRepository.findByEmail(anyString())).thenReturn(Optional.of(savedPatient));
        Exception exception = assertThrows(BadRequestException.class, () -> patientService.addPatient(testData.patientForm));
        assertNotNull(exception);
        assertTrue(exception.getLocalizedMessage().contains("email"));

    }

    @Test
    void editPatient() {
        TestData testData = new TestData();
        PatientForm form = testData.patientForm;
        form.setDateOfBirth("09/09/2000");
        form.setFirstName("ADEWALE");

        when(patientRepository.findById(any(UUID.class))).thenReturn(Optional.of(testData.patient));
        when(patientRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(patientRepository.save(any(Patient.class))).thenAnswer(f -> f.getArguments()[0]);

        Patient patient = patientService.editPatient(form, testData.uuid.toString());
        assertNotNull(patient);
        assertEquals(patient.getDateOfBirth(), LocalDate.of(2000, 9, 9));
        assertEquals(patient.getFirstName(), "Adewale");

        Patient savedPatient = new Patient();
        BeanUtils.copyProperties(testData.patient, savedPatient, "id");
        savedPatient.setId(UUID.randomUUID());

        when(patientRepository.findByEmail(anyString())).thenReturn(Optional.of(savedPatient));
        Exception exception = assertThrows(BadRequestException.class, () -> patientService.addPatient(testData.patientForm));
        assertNotNull(exception);
        assertTrue(exception.getLocalizedMessage().contains("email"));

    }

    @Test
    void deletePatient() {
        TestData testData = new TestData();
        when(patientRepository.findById(any(UUID.class))).thenReturn(Optional.of(testData.patient));
        when(entryService.countPatientEntries(any(Patient.class))).thenReturn(0);
        doNothing().when(patientDetailsService).deletePatientDetails(any(Patient.class));
        Message message = patientService.deletePatient(UUID.randomUUID().toString());
        assertNotNull(message);

        when(entryService.countPatientEntries(any(Patient.class))).thenReturn(1);
        Exception exception = assertThrows(BadRequestException.class, () -> patientService.deletePatient(UUID.randomUUID().toString()));
        assertNotNull(exception);
    }
}
