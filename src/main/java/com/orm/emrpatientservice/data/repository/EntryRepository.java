package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.entity.entry.Entry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntryRepository extends JpaRepository<Entry, UUID> {
    Integer countAllByPatient(Patient patient);

    Page<Entry> findAllByPatient(Patient patient, Pageable pageable);
}
