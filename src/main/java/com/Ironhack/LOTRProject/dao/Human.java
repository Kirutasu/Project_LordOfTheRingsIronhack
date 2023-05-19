package com.Ironhack.LOTRProject.dao;

import lombok.Data;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="id")
@Data
public class Human extends Individual {

    @Column
    private String race;

    @Column
    private String kingdom;

    @Column
    private String lineage;


}
