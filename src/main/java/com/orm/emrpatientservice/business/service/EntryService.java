package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.business.exception.BadRequestException;
import com.orm.emrpatientservice.business.exception.NotFoundException;
import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.entity.entry.Entry;
import com.orm.emrpatientservice.data.form.EntryForm;
import com.orm.emrpatientservice.data.form.Message;
import com.orm.emrpatientservice.data.repository.EntryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    Entry saveEntry(EntryForm form, Patient patient) {
        Entry entry = new Entry();
        entry.setPatient(patient);
        entry.setStaffId(form.getStaffId());
        return entryRepository.save(entry);
    }

    Page<Entry> getPatientEntries(Patient patient, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        Page<Entry> entries = entryRepository.findAllByPatient(patient, pageable);

        if(entries.getContent().isEmpty() && entries.getTotalElements() > 0) {
            return getPatientEntries(patient, entries.getTotalPages()-1);
        }
        return entries;
    }

    Entry editEntry(String entryId, String time) {
        Entry entry = getEntry(entryId);
        entry.setTime(Utilities.parseDateTime(time));
        return entryRepository.save(entry);
    }

    Message deleteEntry(String entryId) {
        Entry entry = getEntry(entryId);
        // TODO check if entry has items


        // entryRepository.delete(entry);
        return new Message("Entry deleted");
    }

    Integer countPatientEntries(Patient patient) {
        return entryRepository.countAllByPatient(patient);
    }


    private Entry getEntry(String entryId) {
        UUID id;
        try {
            id = UUID.fromString(entryId);
        } catch (Exception e) {
            throw new BadRequestException("Invalid entry ID");
        }
        return entryRepository.findById(id).orElseThrow(() -> new NotFoundException("Entry not found with " + entryId));
    }
}
