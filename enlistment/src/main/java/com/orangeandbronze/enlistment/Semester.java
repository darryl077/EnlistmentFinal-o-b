package com.orangeandbronze.enlistment;


public class Semester {
	private final String semesterId;
//	private final Section section;
//	private final Student student;
	
//	public Semester(String semesterId,Section section,Student student) {
	public Semester(String semesterId) {
//		if(semesterId.equals(null)){
//			throw new NullPointerException("semesterId must not be null. Was: " + semesterId);
//		}
//		
//		if(section == null){
//			throw new NullPointerException("section nmust not be null. Was: " + semesterId);
//		}
		
		if(!semesterId.equals("open semester")){
			throw new SemesterNotOpenException("Selected semester is no longer open Was: " + semesterId);
		}
		
		this.semesterId = semesterId;
//		this.section = section;
//		this.student = student;
	}
	
}
