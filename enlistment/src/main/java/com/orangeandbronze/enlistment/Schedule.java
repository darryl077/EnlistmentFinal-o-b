package com.orangeandbronze.enlistment;


public class Schedule {
	
	private final Days days;
	private final Period period;
	private final Period period2;

	public Days getDays() {
		return days;
	}


	public Period getPeriod() {
		return period;
	}


	public Period getPeriod2() {
		return period2;
	}


	public Schedule(Days days, Period period,Period period2) {
		this.days = days;
		this.period = period;
		this.period2 = period2;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		Schedule other = (Schedule) obj;
		if (days != other.days)
			return false;
		if (period != other.period)
			return false;
		return true;
	}
	
	
}
