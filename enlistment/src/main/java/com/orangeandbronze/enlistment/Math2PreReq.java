package com.orangeandbronze.enlistment;

//workaround
public class Math2PreReq {
	Math2PreReq(){
		
	}
	
	public enum Math2 {
		Math1
	}
	
	boolean Math2PreReq(Course course){
		for(Math2 math2 : Math2.values()){
			if(course.equals(Math2.Math1)){
				return true;
			}
		}
		return false;
	}
	
}
