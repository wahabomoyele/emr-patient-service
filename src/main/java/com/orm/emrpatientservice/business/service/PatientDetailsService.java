package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.entity.PatientClinicalInfo;
import com.orm.emrpatientservice.data.entity.PatientContactInfo;
import com.orm.emrpatientservice.data.entity.PatientSocialInfo;
import com.orm.emrpatientservice.data.form.ClinicalInfoForm;
import com.orm.emrpatientservice.data.form.ContactInfoForm;
import com.orm.emrpatientservice.data.form.SocialInfoForm;
import com.orm.emrpatientservice.data.repository.PatientClinicalInfoRepository;
import com.orm.emrpatientservice.data.repository.PatientContactInfoRepository;
import com.orm.emrpatientservice.data.repository.PatientSocialInfoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientDetailsService {
    private final PatientClinicalInfoRepository clinicalInfoRepository;
    private final PatientSocialInfoRepository socialInfoRepository;
    private final PatientContactInfoRepository contactInfoRepository;
    private final PatientContactInfoService contactInfoService;

    public PatientDetailsService(PatientClinicalInfoRepository clinicalInfoRepository, PatientSocialInfoRepository socialInfoRepository, PatientContactInfoRepository contactInfoRepository, PatientContactInfoService contactInfoService) {
        this.clinicalInfoRepository = clinicalInfoRepository;
        this.socialInfoRepository = socialInfoRepository;
        this.contactInfoRepository = contactInfoRepository;
        this.contactInfoService = contactInfoService;
    }

    PatientClinicalInfo saveClinicalInfo(ClinicalInfoForm form, Patient patient) {
        PatientClinicalInfo info = findClinicalInfo(patient.getId());
        if(info != null) {
            PatientClinicalInfo.build(form, info);
        } else {
            info = new PatientClinicalInfo();
            PatientClinicalInfo.build(form, info, patient);
        }
        return clinicalInfoRepository.save(info);
    }

    PatientSocialInfo saveSocialInfo(SocialInfoForm form, Patient patient) {
        PatientSocialInfo info = findSocialInfo(patient.getId());
        if(info != null) {
            PatientSocialInfo.build(form, info);
        } else {
            info = new PatientSocialInfo();
            PatientSocialInfo.build(form, info, patient);
        }
        return socialInfoRepository.save(info);
    }

    PatientContactInfo saveContactInfo(ContactInfoForm form, Patient patient) {
        PatientContactInfo info = findContactInfo(patient.getId());
        if(info == null) {
            info = new PatientContactInfo();
            info.setId(patient.getId());
            info.setPatient(patient);
        }
        info.setAddress(contactInfoService.saveAddress(form.getAddressForm(), info.getAddress()));
        info.setNextOfKin(contactInfoService.saveNextOfKin(form.getNextOfKinForm(), info.getNextOfKin()));

        return contactInfoRepository.save(info);
    }



    public PatientClinicalInfo findClinicalInfo(UUID id) {
        return clinicalInfoRepository.findById(id).orElse(null);
    }

    public PatientSocialInfo findSocialInfo(UUID id) {
        return socialInfoRepository.findById(id).orElse(null);
    }

    public PatientContactInfo findContactInfo(UUID id) {
        return contactInfoRepository.findById(id).orElse(null);
    }

    void deletePatientDetails(Patient patient) {
        clinicalInfoRepository.deleteByPatient(patient);
        socialInfoRepository.deleteByPatient(patient);
        contactInfoRepository.deleteByPatient(patient);
    }
}
