package com.Ironhack.LOTRProject.controllerTestIT;

import com.Ironhack.LOTRProject.dao.Dwarf;
import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dao.Human;
import com.Ironhack.LOTRProject.dto.ElfDTO;
import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import com.Ironhack.LOTRProject.repositories.DwarfRepository;
import com.Ironhack.LOTRProject.repositories.ElfRepository;
import com.Ironhack.LOTRProject.repositories.HumanRepository;
import com.Ironhack.LOTRProject.repositories.IndividualRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
public class IndividualControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private IndividualRepository individualRepository;

    @Autowired
    private HumanRepository humanRepository;

    @Autowired
    private DwarfRepository dwarfRepository;

    @Autowired
    private ElfRepository elfRepository;


    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        Dwarf enano1 = new Dwarf();
        enano1.setCharacterName("Gimli");
        enano1.setRaceSpecialization(RaceSpecialization.ARTISAN);
        enano1.setKingdom("Moria");
        enano1.setMiner(true);
        dwarfRepository.save(enano1);
        Human human1 = new Human();
        human1.setCharacterName("Aragorn");
        human1.setRaceSpecialization(RaceSpecialization.TRADE_MASTER);
        human1.setKingdom("Gondor");
        human1.setLineage("Dûnadan");
        humanRepository.save(human1);
        Elf elfo1 = new Elf();
        elfo1.setCharacterName("Legolas");
        elfo1.setLongevity(2500);
        elfo1.setKingdom("Bosque de Mirkwood");
        elfo1.setElfRace("Sylvano");
        elfo1.setRaceSpecialization(RaceSpecialization.MAGIC_RESISTANT);
        elfRepository.save(elfo1);
    }

    @AfterEach
    public void tearDown() {
        elfRepository.deleteAll();
        dwarfRepository.deleteAll();
        humanRepository.deleteAll();
        individualRepository.deleteAll();
    }
// tenemos previamente preparados 3 individuos, uno por raza, que borraremos tras cada test
    @Test
    public void getAllTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/individual/all"))//permite lanzar querys, tipo get o la que sea
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();// 1 misma orden (mira que esta peticion "postman" lance un codigo 200 OK)
        String responseBody = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List elements = objectMapper.readValue(responseBody, new TypeReference<List>() {
        });
        Assertions.assertEquals(elements.size(), 3);
    }

    @Test
    public void postIndividualTest() throws Exception {
        ElfDTO elfo2 = new ElfDTO();
        elfo2.setCharacterName("Thranduil");
        elfo2.setLongevity(3000);
        elfo2.setKingdom("Bosque de Mirkwood");
        elfo2.setElfRace("Sylvano");
        ObjectMapper objectMapper = new ObjectMapper();
        String elfoJson = objectMapper.writeValueAsString(elfo2);
        System.out.println(elfoJson);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/individual/addElf")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(elfoJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Elf elfTestPost = elfRepository.findByCharacterName("Thranduil");
        Assertions.assertEquals(elfTestPost.getElfRace(), elfo2.getElfRace());
        Assertions.assertEquals(elfTestPost.getKingdom(), elfo2.getKingdom());
        Assertions.assertEquals(elfTestPost.getLongevity(), elfo2.getLongevity());
        Assertions.assertEquals(elfTestPost.getCharacterName(), elfo2.getCharacterName());
        elfRepository.delete(elfTestPost);
    }

    //todo se puede ampliar con el resto de tests de posts!
    @Test
    public void deleteIndividualTest() throws Exception {
        int size = individualRepository.findAll().size();
        int id = individualRepository.findAll().get(0).getIndividual_id();
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/individual/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk());
        List lista = individualRepository.findAll();
        Assertions.assertEquals(lista.size(), (size - 1));
    }
}
