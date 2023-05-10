package com.Ironhack.LOTRProject.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Specialization {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String specialization;

}
