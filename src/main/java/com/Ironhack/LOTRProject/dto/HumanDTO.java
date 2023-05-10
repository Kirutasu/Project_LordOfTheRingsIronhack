package com.Ironhack.LOTRProject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HumanDTO extends IndividualDTO {

    @NotNull
    private String humanRace;
    @NotNull
    private String kingdom;
    private String lineage;


}
