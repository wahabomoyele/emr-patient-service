package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.PatientClinicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientClinicalInfoRepository extends JpaRepository<PatientClinicalInfo, UUID> {
}
