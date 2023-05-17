package com.Ironhack.LOTRProject.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class EventsDTO {

    private int id;

    private String eventType;

    private String eventName;

    private Date dateEvent;


}
