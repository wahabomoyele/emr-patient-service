package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.PatientGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PatientGroupRepository extends JpaRepository<PatientGroup, Long> {
    Set<PatientGroup> findAllByIdIn(Set<Long> ids);
}
