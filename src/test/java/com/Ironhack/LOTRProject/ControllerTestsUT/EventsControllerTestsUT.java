package com.Ironhack.LOTRProject.ControllerTestsUT;

import com.Ironhack.LOTRProject.dao.Dwarf;
import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dao.Human;
import com.Ironhack.LOTRProject.dto.EventsDTO;
import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import com.Ironhack.LOTRProject.exceptions.EventNotFoundException;
import com.Ironhack.LOTRProject.repositories.EventsRepository;
import com.Ironhack.LOTRProject.service.EventsService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class EventsControllerTestsUT {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private EventsService eventsService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        }

    @Test
    public void NoEventFoundPatchEventNameTest () throws Exception {
        EventNotFoundException exception = new EventNotFoundException();
        Mockito.when(eventsService.patchEventName(Mockito.anyInt(), Mockito.anyString())).thenThrow(exception);
        MvcResult patchEventName = mockMvc.perform(MockMvcRequestBuilders.patch("/events/patchEvent/eventName/1/Asalto en el puente de Khazad-Dûm"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andReturn();
        String responseBody = patchEventName.getResponse().getContentAsString();
        Assertions.assertEquals(responseBody,exception.getMessage());
    }
    @Test
    public void PatchEventNameTest () throws Exception {
        EventsDTO eventsDTO = new EventsDTO();
        eventsDTO.setId(1);
        eventsDTO.setEventName("Asalto en Osgiliath");
        Mockito.when(eventsService.patchEventName(Mockito.anyInt(), Mockito.anyString())).thenReturn(eventsDTO);
        MvcResult patchEventName = mockMvc.perform(MockMvcRequestBuilders.patch("/events/patchEvent/eventName/1/Asalto en el puente de Khazad-Dûm"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String responseBody = patchEventName.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        EventsDTO eventsDTO2 = objectMapper.readValue(responseBody, eventsDTO.getClass());
        Assertions.assertEquals(eventsDTO2.getId(), eventsDTO.getId());
    }

}
