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
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="PROJECT_ID")
	long projectId;
	@Column(name="GEOLOCATION")
	String geoLocation;
	@Column(name="BILLINGMODEL")
	String billingModel;
	@Column(name="NUMBEROFRESOURCES")
	private int numberOfResources;
	
	public enum ProjectStatus
	{
		COMPLETE,
		INPROGESS,
		PROGESS,
		CANCLED
	}
	
	
	@Enumerated(EnumType.STRING)
    @Column(name = "billingType")
	ProjectStatus projectStatus ;


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


	public String getGeoLocation() {
		return geoLocation;
	}


	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}


	public String getBillingModel() {
		return billingModel;
	}


	public void setBillingModel(String billingModel) {
		this.billingModel = billingModel;
	}


	public int getNumberOfResources() {
		return numberOfResources;
	}


	public void setNumberOfResources(int numberOfResources) {
		this.numberOfResources = numberOfResources;
	}


	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}


	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", geoLocation=" + geoLocation + ", billingModel=" + billingModel
				+ ", numberOfResources=" + numberOfResources + ", projectStatus=" + projectStatus + "]";
	}

	

	

}
