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
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROLE_ID")
	long roleID;
	
	public enum RoleName
	{
		ADMIN,
		SUPERVISOR,
		AGENT
	
	}
	
	@Enumerated(EnumType.STRING)
    @Column(name = "roleName")
	RoleName RoleName ;

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public RoleName getRoleName() {
		return RoleName;
	}

	public void setRoleName(RoleName roleName) {
		RoleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", RoleName=" + RoleName + "]";
	}

	
}