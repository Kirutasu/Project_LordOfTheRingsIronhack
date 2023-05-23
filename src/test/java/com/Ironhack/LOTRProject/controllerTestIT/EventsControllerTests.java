package com.Ironhack.LOTRProject.controllerTestIT;

import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dto.ElfDTO;
import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class EventsControllerTests {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private EventsRepository eventsRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
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

    //todo test de events
}
