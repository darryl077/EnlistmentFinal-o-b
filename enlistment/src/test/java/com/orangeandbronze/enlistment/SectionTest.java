package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Days.*;
import static com.orangeandbronze.enlistment.Period.*;

public class SectionTest {

	@Test
	public void sectionidIsAlphaNumeric() {
		Subject subject = new Subject("ABC123", Course.English);
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P0830),new Room("RM1"),subject);
		assertNotNull(section);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasSpecialCharacters(){
		Subject subject = new Subject("ABC123", Course.English);
		Section section = new Section("ABC123!@#", new Schedule(Days.MTH, Period.P0830),new Room("RM1"),subject);
		assertNotNull(section);
	}
	
	@Test
	public void subjectidIsAlphaNumeric() {
		Subject subject = new Subject("ABC123", Course.English);
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P0830),new Room("RM1"),subject);
		assertNotNull(section);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void subjectIdIsNoneAlphaNumeric() {
		Subject subject = new Subject("ABC!@#", Course.English);
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P0830),new Room("RM1"),subject);
		assertNotNull(section);		
	}
	
	
	
}
