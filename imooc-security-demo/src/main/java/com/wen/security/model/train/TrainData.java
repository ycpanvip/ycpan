package com.wen.security.model.train;

import java.util.List;

public class TrainData {
	private boolean flag;
	
	private int errorCode;
	
	private String dptStation;
	
	private String arrStation;
	
	private String dptDate;
	
	private List<TrainBean> s2sBeanList;
	
	private boolean dptNearby;
	
	private boolean specialLine;
	
	private boolean transfer;
	
	private String dptRealCity;
	
	private int updateTs;
	
	private String wwwRobTicketMaxTaskWarn;
	
	private String status;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDptStation() {
		return dptStation;
	}

	public void setDptStation(String dptStation) {
		this.dptStation = dptStation;
	}

	public String getArrStation() {
		return arrStation;
	}

	public void setArrStation(String arrStation) {
		this.arrStation = arrStation;
	}

	public String getDptDate() {
		return dptDate;
	}

	public void setDptDate(String dptDate) {
		this.dptDate = dptDate;
	}

	public List<TrainBean> getS2sBeanList() {
		return s2sBeanList;
	}

	public void setS2sBeanList(List<TrainBean> s2sBeanList) {
		this.s2sBeanList = s2sBeanList;
	}

	public boolean isDptNearby() {
		return dptNearby;
	}

	public void setDptNearby(boolean dptNearby) {
		this.dptNearby = dptNearby;
	}

	public boolean isSpecialLine() {
		return specialLine;
	}

	public void setSpecialLine(boolean specialLine) {
		this.specialLine = specialLine;
	}

	public boolean isTransfer() {
		return transfer;
	}

	public void setTransfer(boolean transfer) {
		this.transfer = transfer;
	}

	public String getDptRealCity() {
		return dptRealCity;
	}

	public void setDptRealCity(String dptRealCity) {
		this.dptRealCity = dptRealCity;
	}

	public int getUpdateTs() {
		return updateTs;
	}

	public void setUpdateTs(int updateTs) {
		this.updateTs = updateTs;
	}

	public String getWwwRobTicketMaxTaskWarn() {
		return wwwRobTicketMaxTaskWarn;
	}

	public void setWwwRobTicketMaxTaskWarn(String wwwRobTicketMaxTaskWarn) {
		this.wwwRobTicketMaxTaskWarn = wwwRobTicketMaxTaskWarn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TrainData [flag=" + flag + ", errorCode=" + errorCode + ", dptStation=" + dptStation + ", arrStation="
				+ arrStation + ", dptDate=" + dptDate + ", s2sBeanList=" + s2sBeanList + ", dptNearby=" + dptNearby
				+ ", specialLine=" + specialLine + ", transfer=" + transfer + ", dptRealCity=" + dptRealCity
				+ ", updateTs=" + updateTs + ", wwwRobTicketMaxTaskWarn=" + wwwRobTicketMaxTaskWarn + ", status="
				+ status + "]";
	}
}
