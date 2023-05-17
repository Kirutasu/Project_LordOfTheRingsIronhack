package com.Ironhack.LOTRProject.service;

import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.dao.Events;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
