package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.entry.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
