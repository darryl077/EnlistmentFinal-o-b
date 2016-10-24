package com.orangeandbronze.enlistment;

public enum RoomDetails {
	RM1(5), RM2(5);
	private int cap = 0;
	
	RoomDetails (int cap){
		this.cap = cap;
	}
	int getCap(){
		return cap;
	}
	
}
