package com.Ironhack.LOTRProject.controller;

import com.Ironhack.LOTRProject.dto.DwarfDTO;
import com.Ironhack.LOTRProject.dto.ElfDTO;
import com.Ironhack.LOTRProject.dto.HumanDTO;
import com.Ironhack.LOTRProject.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/individual")
public class IndividualController {

    @Autowired
    private IndividualService individualService;


    @PostMapping("/addElf")
    public ResponseEntity addElf (@RequestBody ElfDTO elfDTO){
        return ResponseEntity.ok(individualService.addIndividual(elfDTO));
    }

    @PostMapping("/addHuman")
    public ResponseEntity addHuman (@RequestBody HumanDTO humanDTO){
        return ResponseEntity.ok(individualService.addIndividual(humanDTO));
    }

    @PostMapping("/addDwarf")
    public ResponseEntity addDwarf (@RequestBody DwarfDTO dwarfDTO){
        return ResponseEntity.ok(individualService.addIndividual(dwarfDTO));
    }

    @GetMapping ("/all")
    public ResponseEntity getAll (){
        return ResponseEntity.ok(individualService.getAll());
    }
    //TODO get All elfs, all humans, all dwarfs

    @GetMapping ("/allElfs")
    public ResponseEntity getAllElfs (){
        return ResponseEntity.ok(individualService.getAllElfs());
    }

    @GetMapping ("/allHumans")
    public ResponseEntity getAllHuman (){
        return ResponseEntity.ok(individualService.getAllHumans());
    }

    @GetMapping ("/allDwarfs")
    public ResponseEntity getAllDwarfs (){
        return ResponseEntity.ok(individualService.getAllDwarfs());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteIndividual (@PathVariable int id) {
        return ResponseEntity.ok(individualService.deleteIndividual(id));
    }
}
