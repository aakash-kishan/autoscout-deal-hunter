package com.aakash.autoscout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    // Magic: This gives us .save(), .findAll(), .delete() automatically!
}