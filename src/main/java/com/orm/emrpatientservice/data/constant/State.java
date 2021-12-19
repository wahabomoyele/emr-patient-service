package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.NotFoundException;

public enum State {
    NG_FC(1L, "Abuja"),
    NG_AB(2L, "Abia"),
    NG_AD(3L, "Adamawa"),
    NG_AK(4L, "Akwa Ibom"),
    NG_AN(5L, "Anambra"),
    NG_BA(6L, "Bauchi"),
    NG_BY(7L, "Bayelsa"),
    NG_BE(8L, "Benue"),
    NG_BO(9L, "Borno"),
    NG_CR(10L, "Cross River"),
    NG_DE(11L, "Delta"),
    NG_EB(12L, "Ebonyi"),
    NG_ED(13L, "Edo"),
    NG_EK(14L, "Ekiti"),
    NG_EN(15L, "Enugu"),
    NG_GO(16L, "Gombe"),
    NG_IM(17L, "Imo"),
    NG_JI(18L, "Jigawa"),
    NG_KD(19L, "Kaduna"),
    NG_KN(20L, "Kano"),
    NG_KT(21L, "Katsina"),
    NG_KE(22L, "Kebbi"),
    NG_KO(23L, "Kogi"),
    NG_KW(24L, "Kwara"),
    NG_LA(25L, "Lagos"),
    NG_NA(26L, "Nasarawa"),
    NG_NI(27L, "Niger"),
    NG_OG(28L, "Ogun"),
    NG_ON(29L, "Ondo"),
    NG_OS(30L, "Osun"),
    NG_OY(31L, "Oyo"),
    NG_PL(32L, "Plateau"),
    NG_RI(33L, "Rivers"),
    NG_SO(34L, "Sokoto"),
    NG_TA(35L, "Taraba"),
    NG_YO(36L, "Yobe"),
    NG_ZA(37L, "Zamfara"),
    ;

    private final String name;
    private final Long id;


    State(Long id, String name) {
        this.name = name;
        this.id = id;
    }


    public static State findById(Long id) {
        for (State state : values()) {
            if (state.getId().equals(id)) return state;
        }
        throw new NotFoundException("State with ID: " + id + " not found");
    }

    public static State findByCode(String code) {
        for (State state : values()) {
            if (state.name().equals(code)) return state;
        }
        throw new NotFoundException("State with code: " + code + " not found");
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
