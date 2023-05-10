package com.Ironhack.LOTRProject.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="id")
@Data
public class Dwarf extends Individual {

    @Column
    private String averageHeight;

    @Column
    private String kingdom;

    @Column
    private boolean miner;





}
