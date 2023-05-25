package com.Ironhack.LOTRProject.service;

import com.Ironhack.LOTRProject.dao.Dwarf;
import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dao.Human;
import com.Ironhack.LOTRProject.dto.EventParticipantsDTO;
import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.dao.Events;
import com.Ironhack.LOTRProject.exceptions.EventNotFoundException;
import com.Ironhack.LOTRProject.repositories.DwarfRepository;
import com.Ironhack.LOTRProject.repositories.ElfRepository;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import com.Ironhack.LOTRProject.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private ElfRepository elfRepository;
    @Autowired
    private DwarfRepository dwarfRepository;
    @Autowired
    private HumanRepository humanRepository;

    public EventsDTO addEvent (EventsDTO eventsDTO) {
        Events event = new Events();
        event.setEventType(eventsDTO.getEventType());
        event.setEventName(eventsDTO.getEventName());
        event.setDateEvent(eventsDTO.getDateEvent());
        eventsRepository.save(event);
        eventsDTO.setId(event.getId());
        return eventsDTO;
    }

    public List getAllEvents () {
        List lista = new ArrayList();
        lista.addAll(eventsRepository.findAll());
        return lista;
    }

    public int deleteEvent (int id) {
        eventsRepository.deleteById(id);
        return id;
    }
    public EventsDTO updateEvent (EventsDTO eventsDTO) {
        if (eventsRepository.findById(eventsDTO.getId()).isPresent()) {
            Events events = eventsRepository.findById(eventsDTO.getId()).get();
            events.setEventType(eventsDTO.getEventType());
            events.setEventName(eventsDTO.getEventName());
            events.setDateEvent(eventsDTO.getDateEvent());
            eventsRepository.save(events);
        }
        return eventsDTO;
    }

    public EventsDTO patchEventName (int id, String eventName) throws EventNotFoundException {
        if (eventsRepository.findById(id).isPresent()) {
            Events event = eventsRepository.findById(id).get();
            event.setEventName(eventName);
            eventsRepository.save(event);
            EventsDTO eventDto = new EventsDTO();
            eventDto.setId(event.getId());
            eventDto.setEventName(event.getEventName());
            eventDto.setEventType(event.getEventType());
            eventDto.setDateEvent(event.getDateEvent());
            return eventDto;
        } else {
            throw new EventNotFoundException();
        }
    }

    public EventsDTO addElfsToEvent (EventParticipantsDTO eventParticipantsDTO) {
        if (eventsRepository.findById(eventParticipantsDTO.getId_event()).isPresent()) {
            Events eventOnList = eventsRepository.findById(eventParticipantsDTO.getId_event()).get();
            if (elfRepository.findById(eventParticipantsDTO.getId_individual()).isPresent()) {
                Elf elfOnList = elfRepository.findById(eventParticipantsDTO.getId_individual()).get();
                eventOnList.getParticipants().add(elfOnList);
                eventsRepository.save(eventOnList);
                EventsDTO eventsDTOOnList = new EventsDTO();
                eventsDTOOnList.setId(eventOnList.getId());
                eventsDTOOnList.setEventType(eventOnList.getEventType());
                eventsDTOOnList.setEventName(eventOnList.getEventName());
                eventsDTOOnList.setDateEvent(eventOnList.getDateEvent());
                eventsDTOOnList.setParticipants(eventOnList.getParticipants());
                return eventsDTOOnList;
            }
        }
        return null;
    }

    public EventsDTO addDwarfsToEvent (EventParticipantsDTO eventParticipantsDTO) {
        if (eventsRepository.findById(eventParticipantsDTO.getId_event()).isPresent()) {
            Events eventOnList = eventsRepository.findById(eventParticipantsDTO.getId_event()).get();
            if (dwarfRepository.findById(eventParticipantsDTO.getId_individual()).isPresent()) {
                Dwarf dwarfOnList = dwarfRepository.findById(eventParticipantsDTO.getId_individual()).get();
                eventOnList.getParticipants().add(dwarfOnList);
                dwarfRepository.save(dwarfOnList);
                EventsDTO eventsDTOOnList = new EventsDTO();
                eventsDTOOnList.setId(eventOnList.getId());
                eventsDTOOnList.setEventType(eventOnList.getEventType());
                eventsDTOOnList.setEventName(eventOnList.getEventName());
                eventsDTOOnList.setDateEvent(eventOnList.getDateEvent());
                eventsDTOOnList.setParticipants(eventOnList.getParticipants());
                return eventsDTOOnList;
            }
        }
        return null;
    }

    public EventsDTO addHumansToEvent (EventParticipantsDTO eventParticipantsDTO) {
        if (eventsRepository.findById(eventParticipantsDTO.getId_event()).isPresent()) {
            Events eventOnList = eventsRepository.findById(eventParticipantsDTO.getId_event()).get();
            if (humanRepository.findById(eventParticipantsDTO.getId_individual()).isPresent()) {
                Human humanOnList = humanRepository.findById(eventParticipantsDTO.getId_individual()).get();
                eventOnList.getParticipants().add(humanOnList);
                eventsRepository.save(eventOnList);
                EventsDTO eventsDTOOnList = new EventsDTO();
                eventsDTOOnList.setId(eventOnList.getId());
                eventsDTOOnList.setEventType(eventOnList.getEventType());
                eventsDTOOnList.setEventName(eventOnList.getEventName());
                eventsDTOOnList.setDateEvent(eventOnList.getDateEvent());
                eventsDTOOnList.setParticipants(eventOnList.getParticipants());
                return eventsDTOOnList;
            }
        }
        return null;
    }
}
