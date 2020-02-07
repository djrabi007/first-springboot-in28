package com.shipreck.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.in28minutes.springboot.controller.ShipwreckController;
import com.in28minutes.springboot.model.Shipwreck;
import com.in28minutes.springboot.service.ShipwreckRepository;


public class ShipWreckTest {
	@InjectMocks
	ShipwreckController objCont;
	@Mock
	ShipwreckRepository objRep;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shipreckTest() {
		Shipwreck objShpwreck = populateShipwreck();
		
		Mockito.when(objRep.findById(1L))
		.thenReturn(Optional.of(objShpwreck));
		
		assertTrue(objCont.getShipwreck(1L)
				.getId()==1L);
	}

	private Shipwreck populateShipwreck() {
		Shipwreck objShpwreck= new Shipwreck();
		objShpwreck.setId(1L);
		return objShpwreck;
	}

}
