package com.Ironhack.LOTRProject.repositories;

import com.Ironhack.LOTRProject.dao.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer> {


}
