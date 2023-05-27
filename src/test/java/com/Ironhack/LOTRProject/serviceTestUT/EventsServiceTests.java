package com.Ironhack.LOTRProject.serviceTestUT;


import com.Ironhack.LOTRProject.dao.Events;
import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.exceptions.EventNotFoundException;
import com.Ironhack.LOTRProject.repositories.ElfRepository;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import com.Ironhack.LOTRProject.service.EventsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EventsServiceTests {

    @Mock
    private EventsRepository eventsRepository;
    @InjectMocks
    private EventsService eventsService;
    @Mock
    private ElfRepository elfRepository;

    @Test
    public void patchEventNameTest() throws EventNotFoundException {
        Events event = new Events();
        event.setId(2);
        event.setEventName("Concilio de Elrond");
        Mockito.when(eventsRepository.findById(2)).thenReturn(Optional.of(event));
        Mockito.when(eventsRepository.save(event)).thenReturn(event);
        EventsDTO eventsDTO = eventsService.patchEventName(2, "Asalto en Amon Hen");
        Assertions.assertEquals(eventsDTO.getEventName(), "Asalto en Amon Hen");
    }

    @Test
    public void getAllEventsTest() {
        List<Events> lista = new ArrayList();
        Events evento1 = new Events();
        evento1.setId(10);
        evento1.setEventType("Asalto");
        lista.add(evento1);
        Events evento2 = new Events();
        evento2.setId(100);
        evento2.setEventType("Miscelanea");
        lista.add(evento2);
        Mockito.when(eventsService.getAllEvents()).thenReturn(lista);
        List<Events> listaTest = eventsService.getAllEvents();
        Assertions.assertEquals(lista.size(), listaTest.size());
        Assertions.assertEquals(lista.get(0).getEventType(), listaTest.get(0).getEventType());
        Assertions.assertEquals(lista.get(1).getEventType(), listaTest.get(1).getEventType());
    }

    @Test
    public void deleteEventTest() {
        eventsService.deleteEvent(2);
        Mockito.verify(eventsRepository, Mockito.times(1)).deleteById(2);
    }
}
