package com.Ironhack.LOTRProject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class HumanDTO extends IndividualDTO {

    @NotEmpty
    private String race;
    @NotNull
    private String kingdom;
    private String lineage;


}
