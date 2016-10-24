package com.orangeandbronze.enlistment;

public class SemesterNotOpenException extends RuntimeException {
	SemesterNotOpenException(String message){
		super(message);
	}
}
