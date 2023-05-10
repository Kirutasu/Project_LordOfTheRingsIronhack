package com.Ironhack.LOTRProject.controller;

import com.Ironhack.LOTRProject.dto.IndividualDTO;
import com.Ironhack.LOTRProject.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/individual")
public class IndividualController {

    @Autowired
    private IndividualService individualService;


    @PostMapping("/add")
    public ResponseEntity<IndividualDTO> addIndividual (@RequestBody IndividualDTO individualDTO){
        return ResponseEntity.ok(individualService.addIndividual(individualDTO));
    }

}
