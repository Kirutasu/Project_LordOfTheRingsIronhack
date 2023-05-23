package com.Ironhack.LOTRProject.models;

import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import lombok.Data;

@Data
public class Elf extends Individual {

    private String kingdom;
    private int longevity;
    private String elfRace;
    private RaceSpecialization raceSpecialization;

}
