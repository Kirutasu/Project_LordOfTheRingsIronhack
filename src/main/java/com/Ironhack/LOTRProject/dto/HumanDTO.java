package com.Ironhack.LOTRProject.dto;

import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class HumanDTO extends IndividualDTO {

    @NotEmpty
    private RaceSpecialization raceSpecialization;
    @NotEmpty
    private String kingdom;
    @NotEmpty
    private String lineage;


}
