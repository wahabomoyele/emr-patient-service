package com.orm.emrpatientservice.data.form;

public class EntryForm {
    private String patientId;
    private String staffId;


    public EntryForm(String patientId, String staffId) {
        this.patientId = patientId;
        this.staffId = staffId;
    }

    public EntryForm() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
