package com.Ironhack.LOTRProject.dao;

import lombok.Data;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="id")
@Data
public class Elf extends Individual {

    @Column
    private String kingdom;

    @Column
    private int maxAge;

    @Column
    private String elfRace;

}
