package com.Ironhack.LOTRProject.dto;

import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ElfDTO extends IndividualDTO {

    @NotNull
    private String kingdom;
    @Min(1)
    @Max(10000)
    private int Longevity;
    @NotEmpty
    private String elfRace;



}
