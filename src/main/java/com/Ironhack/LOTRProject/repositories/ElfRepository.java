package com.Ironhack.LOTRProject.repositories;

import com.Ironhack.LOTRProject.dao.Elf;
import com.Ironhack.LOTRProject.dto.ElfDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElfRepository extends JpaRepository<Elf,Integer> {

     Elf findByCharacterName (String characterName);
}
