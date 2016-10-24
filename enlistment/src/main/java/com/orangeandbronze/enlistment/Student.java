package com.orangeandbronze.enlistment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Student {

	private final Integer studentNumber;
	private final Collection<Section> sections = new HashSet<Section>();

	public Student(Integer studentNumber) {
		if(studentNumber < 0){
			throw new IllegalArgumentException("Student number must be non-negative. Was: " + studentNumber);
		}
		this.studentNumber = studentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}

	public void enlist(Section newSection) {
		if (newSection == null){
			throw new NullPointerException("Section cannot be null.");
		}
		
		if(!checkForTimeOverlaps(newSection.getSchedule())){
			throw new InvalidTimeException("The periods time is invalid");
		}
		
		for(Section currSection: sections){
			currSection.checkForConflictWith(newSection);			
			
		}

		sections.add(newSection);
		
	}
	
	public Collection<Section> getSections(){
		
		return new ArrayList<>(sections);
		
	}
	boolean checkForTimeOverlaps(Schedule other){
		boolean flag = true;
		String lowerBound = other.getPeriod().toString().substring(1);
		String upperBound = other.getPeriod2().toString().substring(1);
		System.out.println(lowerBound);
		System.out.println(upperBound);
		if(Integer.valueOf(lowerBound) >= Integer.valueOf(upperBound)){
			System.out.println(flag);
			flag = false;
		}
		System.out.println(flag);
		return flag;
	}
		
	
}
