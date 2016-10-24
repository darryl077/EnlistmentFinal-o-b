package com.orangeandbronze.enlistment;

public class Room {
	
	private final String roomName;
	private static int roomCapacity = 10;
	private static int capacityNum = 0; 
	
	
	public Room(String roomName){
		if(roomName == null){
			throw new NullPointerException("Room name must not be null");
		}
		if(!roomName.matches("[A-Za-z0-9]+")){
			throw new IllegalArgumentException("Room name must be alphanumeric. Was: " + roomName);
		}
		if(capacityNum == roomCapacity){
			throw new IllegalArgumentException("Room Capacity Reached!");
		}
		
		this.roomName = roomName;		
		capacityNum++;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
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
		Room other = (Room) obj;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [roomName=" + roomName + "]";
	}
	
	
	
}
