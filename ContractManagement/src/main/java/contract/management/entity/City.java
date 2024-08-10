package contract.management.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="CITY_ID")
	long id;
	@Column(name="CITY_NAME")
	String cityName;
	
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name= "city_Ids")
    @OneToOne
    @JoinColumn(name = "city_Ids")
    private ClientMaster clientMaster;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
