package com.Ironhack.LOTRProject.repositories;

import com.Ironhack.LOTRProject.dao.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EventsRepository extends JpaRepository<Events,Integer> {
}
