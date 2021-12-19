package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.business.exception.BadRequestException;
import com.orm.emrpatientservice.business.exception.NotFoundException;
import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.form.Message;
import com.orm.emrpatientservice.data.form.PatientForm;
import com.orm.emrpatientservice.data.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientGroupService patientGroupService;
    private final EntryService entryService;
    private final PatientDetailsService patientDetailsService;

    public PatientService(PatientRepository patientRepository, PatientGroupService patientGroupService, EntryService entryService, PatientDetailsService patientDetailsService) {
        this.patientRepository = patientRepository;
        this.patientGroupService = patientGroupService;
        this.entryService = entryService;
        this.patientDetailsService = patientDetailsService;
    }

    public Patient getPatient(String id) {
        return patientRepository.findById(Utilities.getId(id)).orElseThrow(() -> new NotFoundException("Patient not found with ID: " + id));
    }

    public Patient addPatient(PatientForm form) {
        Patient patient = new Patient();
        Patient.build(form, patient);
        checkEmail(form.getEmail(), patient);
        patient.setGroups(patientGroupService.findGroups(form.getGroups()));
        return patientRepository.save(patient);
    }

    public Patient editPatient(PatientForm form, String id) {
        Patient patient = getPatient(id);
        checkEmail(form.getEmail(), patient);
        Patient.build(form, patient);
        return patientRepository.save(patient);
    }

    public Message deletePatient(String id) {
        Patient patient = getPatient(id);
        if(entryService.countPatientEntries(patient) > 0) throw new BadRequestException("Entries found for patient");
        patientDetailsService.deletePatientDetails(patient);
        patientRepository.delete(patient);
        return new Message("Patient deleted");
    }

    private void checkEmail(String email, Patient patient) {
        if(email != null) {
            Optional<Patient> patientOptional = patientRepository.findByEmail(email);
            if(patientOptional.isPresent()) {
                Patient savedPatient = patientOptional.get();
                if(!savedPatient.getId().equals(patient.getId()))
                    throw new BadRequestException("Patient already exist with email: "+ email);
            }
        }
    }


}
