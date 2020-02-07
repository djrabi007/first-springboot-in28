package com.in28minutes.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.model.Alien;
import com.in28minutes.springboot.model.Shipwreck;

public interface AlienRepo extends JpaRepository<Alien, Long>{

}
