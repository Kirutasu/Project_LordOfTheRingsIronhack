package com.Ironhack.LOTRProject.repositories;

import com.Ironhack.LOTRProject.dao.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual,Integer> {


}
