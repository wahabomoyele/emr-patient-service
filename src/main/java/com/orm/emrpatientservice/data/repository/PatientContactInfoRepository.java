package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.PatientContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientContactInfoRepository extends JpaRepository<PatientContactInfo, UUID> {
}
