package contract.management.dto;

import contract.management.entity.CrtToSow;

public class CrtToSowDto {
	
	private long crId ;
	private String crName;
	private  Double amount;
	private CrtToSow.CrStatus crStatus;
	public long getCrId() {
		return crId;
	}
	public void setCrId(long crId) {
		this.crId = crId;
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public CrtToSow.CrStatus getCrStatus() {
		return crStatus;
	}
	public void setCrStatus(CrtToSow.CrStatus crStatus) {
		this.crStatus = crStatus;
	}
	@Override
	public String toString() {
		return "CrtToSowDto [crId=" + crId + ", crName=" + crName + ", amount=" + amount + ", crStatus=" + crStatus
				+ "]";
	}
	
	


}
