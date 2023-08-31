package com.example.prog4.service;

import com.example.prog4.model.enums.BirthdayEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

public class AgeUtils {
    public static int howOldAmI(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
    public static int howOldAmIForPDF(LocalDate birthdate, BirthdayEnum enums) {
        if(enums == BirthdayEnum.BIRTHDAY) {
            return Period.between(birthdate, LocalDate.now()).getYears();
        } else if (enums == BirthdayEnum.YEAR_ONLY) {
            return birthdate.getYear() - LocalDate.now().getYear();
        }
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
