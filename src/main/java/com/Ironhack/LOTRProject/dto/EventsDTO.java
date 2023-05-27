package com.Ironhack.LOTRProject.dto;

import com.Ironhack.LOTRProject.dao.Individual;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class EventsDTO {

    @NotNull
    private int id;

    @NotEmpty
    private String eventType;

    @NotEmpty
    private String eventName;

    private Date dateEvent;

    private List<Individual> participants;


}
