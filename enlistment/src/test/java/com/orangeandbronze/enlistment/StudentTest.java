package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Days.*;
import static com.orangeandbronze.enlistment.Period.*;
public class StudentTest {

	
	@Test
	public void enlistTwoSectionsNoSchedConflict(){
		Subject subject1 = new Subject("ABC123", Course.English);
		Subject subject2 = new Subject("XYZ123", Course.Math2);
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P830,Period.P930);
		Schedule sched2 = new Schedule(Days.TF, Period.P1000,Period.P1130);
		Semester semester = new Semester("open semester");
		Section sec1 = new Section("ABC", sched1,new Room("RM1"),subject1,semester);
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject2,semester);		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
		
	}

	@Test(expected = ScheduleconflictException.class)
	public void enlistTwoSectionsSameSchedule(){
		Semester semester = new Semester("open semester");
		Subject subject1 = new Subject("ABC123", Course.English);
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P830,Period.P930);
		Schedule sched2 = new Schedule(Days.MTH, Period.P830,Period.P930);
		Section sec1 = new Section("ABC", sched1, new Room("RM1"),subject1,semester);
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject1,semester);		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
	}
	
	@Test(expected = SubjectconflictException.class)
	public void enlistTwoSectionsSameSubject(){
		Semester semester = new Semester("open semester");
		Subject subject1 = new Subject("ABC123", Course.English);
		Subject subject2 = new Subject("ABC12", Course.English);
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P830,Period.P930);
		Schedule sched2 = new Schedule(Days.TF, Period.P830,Period.P930);
		Section sec1 = new Section("ABC", sched1, new Room("RM1"),subject1,semester);
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject2,semester);		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
	}
	
	@Test(expected = SubjectconflictException.class)
	public void enlistTwoSectionsSameSubjectId(){
		Semester semester = new Semester("open semester");
		Subject subject1 = new Subject("ABC123", Course.English);
		Subject subject2 = new Subject("ABC123", Course.Math2);
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P830,Period.P930);
		Schedule sched2 = new Schedule(Days.TF, Period.P830,Period.P930);
		Section sec1 = new Section("ABC", sched1, new Room("RM1"),subject1,semester);
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject2,semester);		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
	}
	
	@Test(expected = SemesterNotOpenException.class)
	public void SemesterNotOpen(){
		Subject subject1 = new Subject("ABC123", Course.English);
		Subject subject2 = new Subject("XYZ123", Course.Math2);
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P830,Period.P930);
		Schedule sched2 = new Schedule(Days.TF, Period.P1000,Period.P1130);
		Semester semester = new Semester("Not open");
		Section sec1 = new Section("ABC", sched1,new Room("RM1"),subject1,semester);
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject2,semester);		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
		
	}
	
	@Test(expected = InvalidTimeException.class)
	public void timeUpperboundIsGreaterThanLowerbound(){
		Subject subject1 = new Subject("ABC123", Course.English);
		Subject subject2 = new Subject("XYZ123", Course.Math2);
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P930,Period.P830);
		Schedule sched2 = new Schedule(Days.TF, Period.P1000,Period.P1130);
		Semester semester = new Semester("open semester");
		Section sec1 = new Section("ABC", sched1,new Room("RM1"),subject1,semester);
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject2,semester);
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
	}
	
//	@Test(expected = InvalidTimeException.class)
//	public void timeOfOtherSubjectPeriod(){
//		Subject subject1 = new Subject("ABC123", Course.English);
//		Subject subject2 = new Subject("XYZ123", Course.Math2);
//		Student student = new Student(1);
//		Schedule sched1 = new Schedule(Days.MTH, Period.P830,Period.P1130);
//		Schedule sched2 = new Schedule(Days.TF, Period.P1000,Period.P1130);
//		Semester semester = new Semester("open semester");
//		Section sec1 = new Section("ABC", sched1,new Room("RM1"),subject1,semester);
//		Section sec2 = new Section("XYZ", sched2,new Room("RM2"),subject2,semester);
//		
//		student.enlist(sec1);
//		student.enlist(sec2);
//		
//		assertTrue(student.getSections().contains(sec1));
//		assertTrue(student.getSections().contains(sec2));
//	}
	
}
