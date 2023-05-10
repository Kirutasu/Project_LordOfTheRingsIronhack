package com.Ironhack.LOTRProject.service;

import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.dao.Events;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventsRepository eventsRepository;

    public EventsDTO addEvent (EventsDTO eventsDTO) {
        Events event = new Events();
        event.setEventType(eventsDTO.getEventType());
        eventsRepository.save(event);
        return eventsDTO;
    }
}
