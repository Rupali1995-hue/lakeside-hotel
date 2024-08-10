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
@Table(name="billing_ model")
public class BillingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long billingId;
	public enum BillingType{
		TRA,
		FXD
	}
	
	@Enumerated(EnumType.STRING)
    @Column(name = "billingType")
	BillingType billingType ;

	public long getBillingId() {
		return billingId;
	}

	public void setBillingId(long billingId) {
		this.billingId = billingId;
	}

	public BillingType getBillingType() {
		return billingType;
	}

	public void setBillingType(BillingType billingType) {
		this.billingType = billingType;
	}
}
