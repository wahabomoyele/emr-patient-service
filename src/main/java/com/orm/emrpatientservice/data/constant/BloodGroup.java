package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

public enum BloodGroup {
    A_POSITIVE(101, "A+"),
    A_NEGATIVE(402, "A-"),
    B_POSITIVE(703, "B+"),
    B_NEGATIVE(204, "B-"),
    AB_POSITIVE(705, "AB+"),
    AB_NEGATIVE(606, "AB-"),
    O_POSITIVE(907, "O+"),
    O_NEGATIVE(108, "O-")
    ;

    public static BloodGroup findById(Integer id) {
        for(BloodGroup bloodGroup : BloodGroup.values()) {
            if(bloodGroup.getId().equals(id)) return bloodGroup;
        }
        throw new BadRequestException("Invalid blood group id");
    }

    private final Integer id;
    private final String name;

    BloodGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
