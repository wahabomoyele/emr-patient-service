package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
