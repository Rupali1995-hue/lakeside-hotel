package contract.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="geolocation")
public class GeoLoation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="geoLocation_Id")
	private long geoLocationId;
	@Column(name="GEOLOCATION_NAME")
	String geoLocationName;//
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geoLocation_Id")
     ClientMaster clientMaster;

	
	public long getGeoLocationId() {
		return geoLocationId;
	}
	public void setGeoLocationId(long geoLocationId) {
		this.geoLocationId = geoLocationId;
	}
	public String getGeoLocationName() {
		return geoLocationName;
	}
	public void setGeoLocationName(String geoLocationName) {
		this.geoLocationName = geoLocationName;
	}
	@Override
	public String toString() {
		return "GeoLoation [geoLocationId=" + geoLocationId + ", geoLocationName=" + geoLocationName + "]";
	}

	
}
