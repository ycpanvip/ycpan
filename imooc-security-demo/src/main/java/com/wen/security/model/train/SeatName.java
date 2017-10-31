package com.wen.security.model.train;

public class SeatName {
	private SeatMap seatMap;
	
	private double price;
	
	private boolean enable;
	
	private int count;

	public SeatMap getSeatMap() {
		return seatMap;
	}

	public void setSeatMap(SeatMap seatMap) {
		this.seatMap = seatMap;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SeatName [seatMap=" + seatMap + ", price=" + price + ", enable=" + enable + ", count=" + count + "]";
	}
}
