package com.Ironhack.LOTRProject.serviceTestUT;

import com.Ironhack.LOTRProject.dao.Dwarf;
import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dao.Human;
import com.Ironhack.LOTRProject.enums.RaceSpecialization;
import com.Ironhack.LOTRProject.repositories.DwarfRepository;
import com.Ironhack.LOTRProject.repositories.ElfRepository;
import com.Ironhack.LOTRProject.repositories.HumanRepository;
import com.Ironhack.LOTRProject.service.IndividualService;
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


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class IndividualServiceTests {
// vamos a probar la logica del componente Individual (mockeando un get all y dando una salida simulada, nos da igual
    // lo que devuelva de base de datos

    @Mock
    private HumanRepository humanRepository;

    @Mock
    private DwarfRepository dwarfRepository;

    @Mock
    private ElfRepository elfRepository;

    @InjectMocks
    private IndividualService individualService;

    @Test
    public void getAll () {
        List listaElf = new ArrayList();
        List listaDwarf = new ArrayList();
        List listaHuman = new ArrayList();
        Dwarf enano1 = new Dwarf ();
        enano1.setCharacterName("Gimli");
        enano1.setRaceSpecialization(RaceSpecialization.ARTISAN);
        enano1.setKingdom("Moria");
        enano1.setMiner(true);
        Human human1 = new Human ();
        human1.setCharacterName("Aragorn");
        human1.setRace("Montaraz");
        human1.setKingdom("Gondor");
        human1.setLineage("Dûnadan");
        Elf elfo1 = new Elf ();
        elfo1.setCharacterName("Legolas");
        elfo1.setMaxAge(2500);
        elfo1.setKingdom("Bosque prohibido");
        elfo1.setElfRace("Sylvano");
        listaElf.add(elfo1);
        listaDwarf.add(enano1);
        listaHuman.add(human1);
        Mockito.when(elfRepository.findAll()).thenReturn(listaElf);
        Mockito.when(humanRepository.findAll()).thenReturn(listaHuman);
        Mockito.when(dwarfRepository.findAll()).thenReturn(listaDwarf);
        List listaGet = individualService.getAll();
        Assertions.assertEquals(listaGet.size(), listaElf.size()+listaDwarf.size()+listaHuman.size());
        Mockito.verify(elfRepository, Mockito.times(1)).findAll();
        Mockito.verify(humanRepository, Mockito.times(1)).findAll();
        Mockito.verify(dwarfRepository, Mockito.times(1)).findAll();
    }


}
