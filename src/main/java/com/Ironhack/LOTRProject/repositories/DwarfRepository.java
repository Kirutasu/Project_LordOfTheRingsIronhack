package com.Ironhack.LOTRProject.repositories;

import com.Ironhack.LOTRProject.dao.Dwarf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwarfRepository extends JpaRepository<Dwarf,Integer> {


}
