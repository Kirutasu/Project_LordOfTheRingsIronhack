package com.Ironhack.LOTRProject.service;

import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.dao.Events;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

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

    public EventsDTO patchEventName (int id, String eventName) {
        Events event = eventsRepository.findById(id).get();
        if (eventsRepository.findById(id).isPresent()) {
            event.setEventName(eventName);
            eventsRepository.save(event);

            EventsDTO eventDto = new EventsDTO();
            eventDto.setId(event.getId());
            eventDto.setEventName(event.getEventName());

            return eventDto;

        } else {
            return null;
        } // TODO REVISAR PORQUE XD no null? eventDTO?
    }
}
