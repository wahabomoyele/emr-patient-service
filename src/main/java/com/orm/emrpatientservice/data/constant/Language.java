package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.lowerCase;

public enum  Language {
    ENGLISH(1, "English"),
    HAUSA(2, "Hausa"),
    YORUBA(3, "Yoruba"),
    IGBO(4, "Igbo"),
    FULFULDE(5, "Fulfulde"),
    KANURI(6, "Kanuri"),
    TIV(7, "Tiv"),
    IJAW(8, "Ijaw"),
    EDO(9, "Edo"),
    ANNANG(10, "Annang"),
    ARABIC(11, "Arabic"),
    IGALA(12, "Igala"),
    FRENCH(13, "French"),
    IDOMA(14, "Idoma"),
    NUPE(15, "Nupe"),
    ITSEKIRI(16, "Itsekiri"),
    PIDGIN(17, "Pidgin");

    private final Integer id;
    private final String name;

    Language(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Language findByName(String name) {
        name = capitalize(lowerCase(name));
        for (Language language : Language.values()) {
            if(language.getName().equals(name))return language;
        }
        Language language = findById(name);
        if(language == null) throw new BadRequestException("Invalid language: " + name);
        return language;
    }

    private static Language findById(String a) {
        try {
            Integer id = Integer.valueOf(a);
            for(Language language : Language.values()) {
                if(language.id.equals(id)) return language;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
