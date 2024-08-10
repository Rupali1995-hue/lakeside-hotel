package contract.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crt_to_sow")
public class CrtToSow {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="CR_ID")
	private long crId ;
	@Column(name="CR_NAME")
	private String crName;
	@Column(name="AMOUNT")
	private  Double amount;
	
	public enum CrStatus{
		    INPROGESS, COMPLETED
	}
	
	
	@Enumerated(EnumType.STRING)
    @Column(name = "crStatus")
	CrStatus crStatus ;


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


	public CrStatus getCrStatus() {
		return crStatus;
	}


	public void setCrStatus(CrStatus crStatus) {
		this.crStatus = crStatus;
	}


	@Override
	public String toString() {
		return "CrtToSow [crId=" + crId + ", crName=" + crName + ", amount=" + amount + ", crStatus=" + crStatus + "]";
	}
	
	
}
