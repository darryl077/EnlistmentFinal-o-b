package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Days.*;
import static com.orangeandbronze.enlistment.Period.*;

public class SectionTest {

	@Test
	public void sectionidIsAlphaNumeric() {
		Subject subject = new Subject("ABC123", Course.English);
		Semester semester = new Semester("open semester");
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P830,Period.P930),new Room("RM1"),subject,semester);
		assertNotNull(section);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasSpecialCharacters(){
		Semester semester = new Semester("open semester");
		Subject subject = new Subject("ABC123", Course.English);
		Section section = new Section("ABC123!@#", new Schedule(Days.MTH, Period.P830,Period.P930),new Room("RM1"),subject,semester);
		assertNotNull(section);
	}
	
	@Test
	public void subjectidIsAlphaNumeric() {
		Semester semester = new Semester("open semester");
		Subject subject = new Subject("ABC123", Course.English);
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P830,Period.P930),new Room("RM1"),subject,semester);
		assertNotNull(section);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void subjectIdIsNoneAlphaNumeric() {
		Semester semester = new Semester("open semester");
		Subject subject = new Subject("ABC!@#", Course.English);
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P830,Period.P930),new Room("RM1"),subject,semester);
		assertNotNull(section);		
	}
	
	@Test(expected = SemesterNotOpenException.class)
	public void SemesterNotOpen() {
		Semester semester = new Semester("Not Open");
		Subject subject = new Subject("ABC!@#", Course.English);
		Section section = new Section("ABC123", new Schedule(Days.MTH, Period.P830,Period.P930),new Room("RM1"),subject,semester);
		assertNotNull(section);		
	}
	
	
	
}
