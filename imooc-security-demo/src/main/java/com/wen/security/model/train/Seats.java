package com.wen.security.model.train;

import java.util.Map;

public class Seats {
	
	private Map<String, SeatName> seatName;

	public Map<String, SeatName> getSeatName() {
		return seatName;
	}

	public void setSeatName(Map<String, SeatName> seatName) {
		this.seatName = seatName;
	}

	@Override
	public String toString() {
		return "Seats [seatName=" + seatName + "]";
	}
}
