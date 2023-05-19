package com.Ironhack.LOTRProject.repositories;

import com.Ironhack.LOTRProject.dao.Elf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElfRepository extends JpaRepository<Elf,Integer> {

     Elf findByCharacterName (String characterName);
}
