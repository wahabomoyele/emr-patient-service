package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.UUID;

public class Utilities {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("en"));
    private static final DateTimeFormatter DATE_FORMAT2 = DateTimeFormatter.ofPattern("yyyy/MM/dd", new Locale("en"));


    public static UUID getId(String uuidString) {
        try {
            return UUID.fromString(uuidString);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid id");
        }
    }

    public static LocalDate parseDate(String dateString) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            try {
                date = LocalDate.parse(dateString, DATE_FORMAT2);
            } catch (DateTimeParseException e2) {
                throw new BadRequestException("Invalid date format. Use DD/MM/YYYY or YYYY/MM/DD");
            }
        }
        return date;
    }
}
