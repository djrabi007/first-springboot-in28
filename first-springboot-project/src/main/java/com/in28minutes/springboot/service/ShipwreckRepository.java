package com.in28minutes.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.springboot.model.Shipwreck;
/**
 * Repository Provided by Spring
 * The 2 dependency is required to have Repository
 * 
 * <!-- Spring Data JPA Dependency -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<!-- H2 database Dependency -->
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>
 * @author Rabi
 *
 */
/*@RepositoryRestResource(collectionResourceRel = "shipwrecks", path = "shipwreck")
public interface ShipwreckRepository extends PagingAndSortingRepository<Shipwreck, Long> {
public List<Integer> findByYearDiscovered(String yearDiscovered );

}*/

public interface ShipwreckRepository
		extends JpaRepository<Shipwreck, Long> {}