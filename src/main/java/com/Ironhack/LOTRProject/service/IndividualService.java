package com.Ironhack.LOTRProject.service;

import com.Ironhack.LOTRProject.dao.Dwarf;
import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dao.Individual;
import com.Ironhack.LOTRProject.dto.DwarfDTO;
import com.Ironhack.LOTRProject.dto.ElfDTO;
import com.Ironhack.LOTRProject.dto.HumanDTO;
import com.Ironhack.LOTRProject.dto.IndividualDTO;
import com.Ironhack.LOTRProject.repositories.DwarfRepository;
import com.Ironhack.LOTRProject.repositories.ElfRepository;
import com.Ironhack.LOTRProject.repositories.HumanRepository;
import com.Ironhack.LOTRProject.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualService {

    @Autowired
    private IndividualRepository individualRepository;
    @Autowired
    private HumanRepository humanRepository;
    @Autowired
    private ElfRepository elfRepository;
    @Autowired
    private DwarfRepository dwarfRepository;


    public IndividualDTO addIndividual (IndividualDTO individualDTO) {
        Individual individual = new Individual();
        individual.setCharacterName(individualDTO.getCharacterName());
        //individual = individualRepository.save(individual);
        if (individualDTO instanceof ElfDTO) {
          ElfDTO elfDto = (ElfDTO) individualDTO;
          Elf elf = new Elf ();
          elf.setIndividual_id(individual.getIndividual_id());
          elf.setCharacterName(individual.getCharacterName());
          elf.setKingdom(elfDto.getKingdom());
          elf.setMaxAge(elfDto.getMaxAge());
          elf.setElfRace(elfDto.getElfRace());
          elfRepository.save(elf);
          return elfDto;
        }
        else if (individualDTO instanceof DwarfDTO) {
            DwarfDTO dwarfDTO = (DwarfDTO) individualDTO;
            Dwarf dwarf = new Dwarf();
            dwarf.setIndividual_id(individual.getIndividual_id());
            dwarf.setCharacterName(individual.getCharacterName());
            dwarf.setAverageHeight(dwarfDTO.getAverageHeight());
            dwarf.setKingdom(dwarfDTO.getKingdom());
            dwarf.setMiner(dwarfDTO.isMiner());
            dwarfRepository.save(dwarf);
            return dwarfDTO;
        }
        else if(individualDTO instanceof HumanDTO) {
            HumanDTO humanDTO = (HumanDTO) individualDTO;

        }

        return individualDTO;
    }

    public List getAll () {
        List lista = new ArrayList();
        lista.addAll(elfRepository.findAll());
        lista.addAll(dwarfRepository.findAll());
        lista.addAll(humanRepository.findAll());
        return lista;
    }

    public List getAllElfs () {
        List lista = new ArrayList();
        lista.addAll(elfRepository.findAll());
        return lista;
    }

    public List getAllHumans () {
        List lista = new ArrayList();
        lista.addAll(humanRepository.findAll());
        return lista;
    }

    public List getAllDwarfs () {
        List lista = new ArrayList();
        lista.addAll(dwarfRepository.findAll());
        return lista;
    }

    public int deleteIndividual (int id) {
        individualRepository.deleteById(id);
        return id;
    }
}
