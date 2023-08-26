package com.example.prog4.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

public class AgeUtils {
    public static int howOldAmI(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
