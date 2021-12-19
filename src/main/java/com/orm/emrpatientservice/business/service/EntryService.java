package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.repository.EntryRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    Integer countPatientEntries(Patient patient) {
        return entryRepository.countAllByPatient(patient);
    }
}
