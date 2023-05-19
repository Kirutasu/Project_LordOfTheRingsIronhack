package com.Ironhack.LOTRProject.dto;

import com.Ironhack.LOTRProject.dao.Individual;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class EventsDTO {

    private int id;

    private String eventType;

    private String eventName;

    private Date dateEvent;

    private List<Individual> participants;


}
