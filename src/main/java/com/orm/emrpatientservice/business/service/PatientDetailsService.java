package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.repository.PatientClinicalInfoRepository;
import com.orm.emrpatientservice.data.repository.PatientContactInfoRepository;
import com.orm.emrpatientservice.data.repository.PatientSocialInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientDetailsService {
    private final PatientClinicalInfoRepository clinicalInfoRepository;
    private final PatientSocialInfoRepository socialInfoRepository;
    private final PatientContactInfoRepository contactInfoRepository;

    public PatientDetailsService(PatientClinicalInfoRepository clinicalInfoRepository, PatientSocialInfoRepository socialInfoRepository, PatientContactInfoRepository contactInfoRepository) {
        this.clinicalInfoRepository = clinicalInfoRepository;
        this.socialInfoRepository = socialInfoRepository;
        this.contactInfoRepository = contactInfoRepository;
    }

    void deletePatientDetails(Patient patient) {

    }
}
