package com.Ironhack.LOTRProject.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Individual {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int individual_id;

    @Column
    private String characterName;




}
