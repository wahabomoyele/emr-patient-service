package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.data.entity.PatientGroup;
import com.orm.emrpatientservice.data.repository.PatientGroupRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PatientGroupService {

    private final PatientGroupRepository patientGroupRepository;

    public PatientGroupService(PatientGroupRepository patientGroupRepository) {
        this.patientGroupRepository = patientGroupRepository;
    }

    Set<PatientGroup> findGroups(Set<Long> idSet) {
        return patientGroupRepository.findAllByIdIn(idSet);
    }
}
