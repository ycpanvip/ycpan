package com.wen.security.model.train;

public class SeatMap {
	private int ticketNumStatus;

	public int getTicketNumStatus() {
		return ticketNumStatus;
	}

	public void setTicketNumStatus(int ticketNumStatus) {
		this.ticketNumStatus = ticketNumStatus;
	}

	@Override
	public String toString() {
		return "SeatMap [ticketNumStatus=" + ticketNumStatus + "]";
	}
}
