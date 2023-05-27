package com.Ironhack.LOTRProject.controller;

import com.Ironhack.LOTRProject.dto.EventParticipantsDTO;
import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.exceptions.EventNotFoundException;
import com.Ironhack.LOTRProject.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventsService eventService;

    @PostMapping("/addEvent")
    public ResponseEntity addEvent(@RequestBody EventsDTO eventsDTO) {
        return ResponseEntity.ok(eventService.addEvent(eventsDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEvent(@PathVariable int id) {
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }

    @PatchMapping("/patchEvent/eventName/{id}/{eventName}") //sustituye el parametro eventName por aquel que le introduzcamos nosotros en la ruta
    public ResponseEntity patchEventName(@PathVariable int id, @PathVariable String eventName) throws EventNotFoundException {
        return ResponseEntity.ok(eventService.patchEventName(id, eventName));
    }

    @PutMapping("/updateEvent") //actualiza desde ninguno a todos los parametros de un evento, que le pasaremos por el body
    public ResponseEntity<EventsDTO> updateEvent(@RequestBody EventsDTO eventsDTO) {
        return ResponseEntity.ok(eventService.updateEvent(eventsDTO));
    }

    @PostMapping("/addElfToEvent") //añade un objeto Elfo que le indicamos en el body al evento que igualmente le pasemos idem)
    public ResponseEntity<EventsDTO> addElfsToEvent(@RequestBody EventParticipantsDTO eventParticipantsDTO) {
        return ResponseEntity.ok(eventService.addElfsToEvent(eventParticipantsDTO));
    }

    @PostMapping("/addDwarfToEvent") //añade un objeto Dwarf que le indicamos en el body al evento que igualmente le pasemos idem)
    public ResponseEntity<EventsDTO> addDwarfToEvent(@RequestBody EventParticipantsDTO eventParticipantsDTO) {
        return ResponseEntity.ok(eventService.addDwarfsToEvent(eventParticipantsDTO));
    }

    @PostMapping("/addHumanToEvent") //añade un objeto Human que le indicamos en el body al evento que igualmente le pasemos idem)
    public ResponseEntity<EventsDTO> addHumanToEvent(@RequestBody EventParticipantsDTO eventParticipantsDTO) {
        return ResponseEntity.ok(eventService.addHumansToEvent(eventParticipantsDTO));
    }

}
