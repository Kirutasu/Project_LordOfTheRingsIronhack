package com.Ironhack.LOTRProject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DwarfDTO extends IndividualDTO {

    private String averageHeight;

    @NotNull
    private String kingdom;

    private boolean miner;





}
