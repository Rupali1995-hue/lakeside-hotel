package contract.management.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import contract.management.entity.Attachment;
import contract.management.entity.City;
import contract.management.entity.Country;
import contract.management.entity.GeoLoation;
@Component
public class ClientMasterDto {
	
		private long clientId; 
		String clientName  ;
		//String city;
	    GeoLoation location;
	    List<City> city;
	    List<Country> country;
	    List<Attachment> attachment;
		String projectManager;
		String deliveryHead;
		String salesHead;
		Date startDate;
		Date endDate;
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
		public List<Country> getCountry() {
			return country;
		}
		public void setCountry(List<Country> country) {
			this.country = country;
		}
		public List<Attachment> getAttachment() {
			return attachment;
		}
		public void setAttachment(List<Attachment> attachment) {
			this.attachment = attachment;
		}
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
