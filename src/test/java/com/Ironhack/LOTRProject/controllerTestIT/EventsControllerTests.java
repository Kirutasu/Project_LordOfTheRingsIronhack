package com.Ironhack.LOTRProject.controllerTestIT;

import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dao.Events;
import com.Ironhack.LOTRProject.dto.ElfDTO;
import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class EventsControllerTests {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EventsRepository eventsRepository;

    private MockMvc mockMvc;

    private Events events = new Events();

    private Events events2 = new Events();



    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        events.setEventName("Asalto en la tumba de Balin");
        events.setEventType("Asalto");
        eventsRepository.save(events);
        events2.setEventName("Encuentro en la Taberna el Poney Pisador");
        events2.setEventType("Miscelanea");
        eventsRepository.save(events2);
    }

    @AfterEach
    public void tearDown() {
        eventsRepository.deleteAll();
    }

    @Test
    public void addEventTest() throws Exception {
        EventsDTO eventsDTO = new EventsDTO();
        eventsDTO.setEventName("Aragorn se reune con Frodo");
        eventsDTO.setEventType("Miscelanea");
        ObjectMapper objectMapper = new ObjectMapper();
        String eventJson = objectMapper.writeValueAsString(eventsDTO);
        MvcResult addEventResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/events/addEvent")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(eventJson))
                        .andReturn();
        String responseBody = addEventResult.getResponse().getContentAsString();
        EventsDTO eventsDTO2 = objectMapper.readValue(responseBody, eventsDTO.getClass());
        Assertions.assertEquals(eventsDTO.getEventName(), eventsDTO2.getEventName());
        Assertions.assertEquals(eventsDTO.getEventType(), eventsDTO2.getEventType());
        eventsRepository.deleteById(eventsDTO2.getId());
    }

    @Test
    public void getAllEventsTest() throws Exception {
        MvcResult addEventResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/events/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String responseBody = addEventResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List eventsLista = objectMapper.readValue(responseBody, new TypeReference<List>(){});
        Assertions.assertEquals(((LinkedHashMap)eventsLista.get(0)).get("eventName"), events.getEventName());
        Assertions.assertEquals(((LinkedHashMap)eventsLista.get(1)).get("eventName"), events2.getEventName());
        Assertions.assertEquals(((LinkedHashMap)eventsLista.get(0)).get("eventType"), events.getEventType());
        Assertions.assertEquals(((LinkedHashMap)eventsLista.get(1)).get("eventType"), events2.getEventType());
    }
    //todo alguno+ test de events
    @Test
    public void deleteEvent() throws Exception {
        int id = eventsRepository.findAll().get(0).getId();
        MvcResult addEventResult = this.mockMvc.perform(MockMvcRequestBuilders.delete("/events/"+ id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertEquals(eventsRepository.findAll().size(), 1);
    }

    @Test
    public void PatchEventNameTest () throws Exception {
        int id = eventsRepository.findAll().get(0).getId();
        MvcResult patchEventName = mockMvc.perform(MockMvcRequestBuilders.patch("/events/patchEvent/eventName/" + id + "/Asalto en la cima de los vientos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String responseBody = patchEventName.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        EventsDTO eventsDTO2 = objectMapper.readValue(responseBody, EventsDTO.class);
        Assertions.assertEquals(eventsDTO2.getEventName(), "Asalto en la cima de los vientos");
    }

}
