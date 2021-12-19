package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.data.constant.State;
import com.orm.emrpatientservice.data.entity.Address;
import com.orm.emrpatientservice.data.entity.NextOfKin;
import com.orm.emrpatientservice.data.form.AddressForm;
import com.orm.emrpatientservice.data.form.NextOfKinForm;
import com.orm.emrpatientservice.data.repository.AddressRepository;
import com.orm.emrpatientservice.data.repository.NextOfKinRepository;
import org.springframework.stereotype.Service;


import static org.apache.commons.lang3.StringUtils.*;

@Service
public class PatientContactInfoService {
    private final AddressRepository addressRepository;
    private final NextOfKinRepository nextOfKinRepository;

    public PatientContactInfoService(AddressRepository addressRepository, NextOfKinRepository nextOfKinRepository) {
        this.addressRepository = addressRepository;
        this.nextOfKinRepository = nextOfKinRepository;
    }

    Address saveAddress(AddressForm addressForm, Address address) {
        if(address == null) address = new Address();
        address.setCity(capitalize(lowerCase(trim(addressForm.getCity()))));
        address.setStreet(capitalize(lowerCase(trim(addressForm.getStreet()))));
        address.setState(State.findByCode(addressForm.getState()));
        address.setStateName(address.getState().getName());
        return addressRepository.save(address);
    }

    NextOfKin saveNextOfKin(NextOfKinForm nextOfKinForm, NextOfKin nextOfKin) {
        if(nextOfKin == null) nextOfKin = new NextOfKin();
        NextOfKin.build(nextOfKinForm, nextOfKin);
        return nextOfKinRepository.save(nextOfKin);
    }
}
