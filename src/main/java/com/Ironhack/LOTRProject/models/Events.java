package com.Ironhack.LOTRProject.models;

import lombok.Data;
import java.util.Date;

@Data
public class Events {

    private int id;

    private String eventType;

    private String eventName;

    private Date dateEvent;

}
