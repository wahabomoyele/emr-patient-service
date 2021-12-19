package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.entity.PatientSocialInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientSocialInfoRepository extends JpaRepository<PatientSocialInfo, UUID> {
    void deleteByPatient(Patient patient);
}
