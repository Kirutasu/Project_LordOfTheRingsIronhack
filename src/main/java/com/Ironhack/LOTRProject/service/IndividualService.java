package com.Ironhack.LOTRProject.service;

import com.Ironhack.LOTRProject.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

//TODO instancia?
    /*

    public IndividualDTO addIndividual (IndividualDTO individualDTO) {
        Individual individual = new Individual();

        individual.setCharacterName(individualDTO.getCharacterName());
        individualRepository.save(individual);
        return individualDTO;
    }
     */

}
