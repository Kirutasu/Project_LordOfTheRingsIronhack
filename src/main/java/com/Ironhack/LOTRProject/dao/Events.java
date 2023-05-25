package com.Ironhack.LOTRProject.dao;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
public class Events {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String eventType;

    @Column
    private String eventName;

    @Column
    private Date dateEvent;

    @OneToMany
    private List<Individual> participants;



}
