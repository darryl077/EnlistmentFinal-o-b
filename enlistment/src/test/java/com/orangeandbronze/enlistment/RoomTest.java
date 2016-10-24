package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	@Test
	public void roomIsNotNull() {
		Room room = new Room("RM1");
		assertNotNull(room);
	} 

	@Test
	public void roomIsalpahNumeric() {
		Room room = new Room("RM1");
//		assert
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void roomCapacityTest(){
		Room room1 = new Room("RM1");
		Room room2 = new Room("RM1");
		Room room3 = new Room("RM1");
		

	}

	
}
