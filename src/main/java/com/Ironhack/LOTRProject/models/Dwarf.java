package com.Ironhack.LOTRProject.models;

import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import lombok.Data;

@Data
public class Dwarf extends Individual {

    private RaceSpecialization raceSpecialization;

    private String kingdom;

    private boolean miner;





}
