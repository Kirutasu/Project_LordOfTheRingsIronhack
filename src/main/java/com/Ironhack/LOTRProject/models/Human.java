package com.Ironhack.LOTRProject.models;

import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import lombok.Data;

@Data
public class Human extends Individual {

    private RaceSpecialization raceSpecialization;
    private String kingdom;
    private String lineage;


}
