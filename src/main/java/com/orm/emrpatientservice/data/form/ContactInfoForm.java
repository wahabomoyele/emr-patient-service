package com.orm.emrpatientservice.data.form;

import javax.validation.constraints.NotNull;

public class ContactInfoForm {
    @NotNull
    private NextOfKinForm nextOfKinForm;
    @NotNull
    private AddressForm addressForm;

    public NextOfKinForm getNextOfKinForm() {
        return nextOfKinForm;
    }

    public void setNextOfKinForm(NextOfKinForm nextOfKinForm) {
        this.nextOfKinForm = nextOfKinForm;
    }

    public AddressForm getAddressForm() {
        return addressForm;
    }

    public void setAddressForm(AddressForm addressForm) {
        this.addressForm = addressForm;
    }
}
