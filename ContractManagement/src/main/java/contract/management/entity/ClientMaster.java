package contract.management.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="client_master")
public class ClientMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long clientId; 
	@Column(name="CLIENT_NAME")
	String clientName  ;
	//String city;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geoLocation_Id")
    GeoLoation location;
    
    //@OneToMany(fetch=FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name= "city_Ids")	
    private List<City> city;
    
   // @OneToMany(fetch=FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name= "country_Ids")
   private List<Country> country;

   // @OneToMany(fetch=FetchType.LAZY)
//    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//    @JoinColumn(name="ATTACHMENT_ID")
//    private List<Attachment> attachment;
    
	//String country;
	//String geoLocation;
	@Column(name="PROJECT_MANAGER")
	private String projectManager;
	@Column(name="DELIEVERY_HEAD")
	 private String deliveryHead;
	@Column(name="SALES_HEAD")
	private String salesHead;
	@Column(name="START_DATE")
	private Date startDate;
	@Column(name="END_DATE")
	private Date endDate;
	//String attachment;
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public GeoLoation getLocation() {
		return location;
	}
	public void setLocation(GeoLoation location) {
		this.location = location;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
//	public List<Country> getCountry() {
//		return country;
//	}
//	public void setCountry(List<Country> country) {
//		this.country = country;
//	}
//	public List<Attachment> getAttachment() {
//		return attachment;
//	}
//	public void setAttachment(List<Attachment> attachment) {
//		this.attachment = attachment;
//	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getDeliveryHead() {
		return deliveryHead;
	}
	public void setDeliveryHead(String deliveryHead) {
		this.deliveryHead = deliveryHead;
	}
	public String getSalesHead() {
		return salesHead;
	}
	public void setSalesHead(String salesHead) {
		this.salesHead = salesHead;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

	
}
