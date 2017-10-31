package com.wen.security.model.train;

public class ExtraBeanMap {
	private int tickets;
	
	private String arrDate;
	
	private String trainType;
	
	private String arrCityName;
	
	private String dptDate;
	
	private String stationType;
	
	private String dptCityName;
	
	private boolean deptStationInfo;
	
	private String ticketType;
	
	private int sort;
	
	private boolean ticketsUnknown;
	
	private String startSaleTime;
	
	private String arriTimeRange;
	
	private int sale;
	
	private boolean arriStationInfo;
	
	private String deptTimeRange;
	
	private String interval;
	
	private int intervalMiles;

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public String getArrDate() {
		return arrDate;
	}

	public void setArrDate(String arrDate) {
		this.arrDate = arrDate;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public String getArrCityName() {
		return arrCityName;
	}

	public void setArrCityName(String arrCityName) {
		this.arrCityName = arrCityName;
	}

	public String getDptDate() {
		return dptDate;
	}

	public void setDptDate(String dptDate) {
		this.dptDate = dptDate;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getDptCityName() {
		return dptCityName;
	}

	public void setDptCityName(String dptCityName) {
		this.dptCityName = dptCityName;
	}

	public boolean isDeptStationInfo() {
		return deptStationInfo;
	}

	public void setDeptStationInfo(boolean deptStationInfo) {
		this.deptStationInfo = deptStationInfo;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public boolean isTicketsUnknown() {
		return ticketsUnknown;
	}

	public void setTicketsUnknown(boolean ticketsUnknown) {
		this.ticketsUnknown = ticketsUnknown;
	}

	public String getStartSaleTime() {
		return startSaleTime;
	}

	public void setStartSaleTime(String startSaleTime) {
		this.startSaleTime = startSaleTime;
	}

	public String getArriTimeRange() {
		return arriTimeRange;
	}

	public void setArriTimeRange(String arriTimeRange) {
		this.arriTimeRange = arriTimeRange;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public boolean isArriStationInfo() {
		return arriStationInfo;
	}

	public void setArriStationInfo(boolean arriStationInfo) {
		this.arriStationInfo = arriStationInfo;
	}

	public String getDeptTimeRange() {
		return deptTimeRange;
	}

	public void setDeptTimeRange(String deptTimeRange) {
		this.deptTimeRange = deptTimeRange;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public int getIntervalMiles() {
		return intervalMiles;
	}

	public void setIntervalMiles(int intervalMiles) {
		this.intervalMiles = intervalMiles;
	}

	@Override
	public String toString() {
		return "ExtraBeanMap [tickets=" + tickets + ", arrDate=" + arrDate + ", trainType=" + trainType
				+ ", arrCityName=" + arrCityName + ", dptDate=" + dptDate + ", stationType=" + stationType
				+ ", dptCityName=" + dptCityName + ", deptStationInfo=" + deptStationInfo + ", ticketType=" + ticketType
				+ ", sort=" + sort + ", ticketsUnknown=" + ticketsUnknown + ", startSaleTime=" + startSaleTime
				+ ", arriTimeRange=" + arriTimeRange + ", sale=" + sale + ", arriStationInfo=" + arriStationInfo
				+ ", deptTimeRange=" + deptTimeRange + ", interval=" + interval + ", intervalMiles=" + intervalMiles
				+ "]";
	}
}
