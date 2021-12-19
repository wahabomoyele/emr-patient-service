package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import static org.apache.commons.lang3.StringUtils.*;

public enum Title {
    MR(2, "MR", "A man"),
    MRS(3, "MRS", "A married woman"),
    MS(4, "MS", "An unmarried woman"),
    DR(1, "DR", "A medical doctor or person with a PhD"),
    PROF(5, "PROF", "A professor");


    Title(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Title findByName(String name) {
        name = upperCase(name);

        for (Title title : Title.values()) {
            if(title.getName().equals(name))return title;
        }
        Title title = findById(name);
        if(title == null) throw new BadRequestException("Invalid user title: " + name);
        return title;
    }

    private static Title findById(String a) {
        try {
            Integer id = Integer.valueOf(a);
            for(Title title : Title.values()) {
                if(title.id.equals(id)) return title;
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

    public String getDescription() {
        return description;
    }

    private final Integer id;
    private final String name;
    private final String description;
}
