package com.Ironhack.LOTRProject.dao;

import lombok.Data;
import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.EAGER;

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
