package com.orangeandbronze.enlistment;

public class Subject {
	private final String subjectId;
	private final Course course;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((subjectId == null) ? 0 : subjectId.hashCode());
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
		Subject other = (Subject) obj;
		if (course != other.course)
			return false;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		return true;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public Course getCourse() {
		return course;
	}
	


	
	public Subject(String subjectId, Course course){
		
		if(!subjectId.matches("[A-Za-z0-9]+")){
			throw new IllegalArgumentException("Subject ID must be alphanumeric. Was: " + subjectId);
		}
		
		if(course == null){
			throw new NullPointerException("Room cannot be null. Was: " + course);
		}
		
		this.subjectId = subjectId;
		this.course = course;
	}
}
