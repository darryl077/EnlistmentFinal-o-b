package com.orangeandbronze.enlistment;

public class Section {

	private final String sectionId;
	private final Schedule schedule;
	private final Room room;
	private final Subject subject;
	private final Semester semester;
	
	public Section(String sectionId, Schedule schedule, Room room, Subject subject,Semester semester){

		if(!sectionId.matches("[A-Za-z0-9]+")){
			throw new IllegalArgumentException("Section ID must be alphanumeric. Was: " + sectionId);
		}
		
		if(room == null){
			throw new NullPointerException("Room cannot be null. Was: " + room);
		}
		
		if(schedule == null){
			throw new NullPointerException("Schedule cannot be null. Was: " + schedule);
		}
				
		this.sectionId = sectionId;
		this.schedule = schedule;
		this.room = room;
		this.subject = subject;
		this.semester = semester;
	}

	public Schedule getSchedule() {
		return schedule;
	}
	
	public Room getRoom() {
		return room;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Section other = (Section) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", schedule=" + schedule + ", room=" + room + "]";

	}

	void checkForConflictWith(Section other){
		if(!checkForTimeOverlaps(other.schedule)){
			throw new InvalidTimeException("The periods time is invalid");
		}
		if(this.schedule.equals(other.schedule)){
			throw new ScheduleconflictException("This section has same schedule with other section");
			
		}
		if(this.subject.getCourse().equals(other.subject.getCourse())){
			throw new SubjectconflictException("This Subject is already enlisted");
			
		}
		
		if(this.subject.getSubjectId().equals(other.subject.getSubjectId())){
			throw new SubjectconflictException("This Subject is already enlisted2");
			
		}
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
