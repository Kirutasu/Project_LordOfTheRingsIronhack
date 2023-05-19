package com.Ironhack.LOTRProject.models;

import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Elf extends Individual {

    private String kingdom;
    private int maxAge;
    private String elfRace;
    private RaceSpecialization raceSpecialization;

}
