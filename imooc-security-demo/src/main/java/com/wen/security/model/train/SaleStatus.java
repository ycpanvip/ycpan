package com.wen.security.model.train;

public class SaleStatus {
	private int saleId;
	
	private String desc;

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SaleStatus [saleId=" + saleId + ", desc=" + desc + "]";
	}
}
