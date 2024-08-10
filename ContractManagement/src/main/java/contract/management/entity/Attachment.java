package contract.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="attachment")
public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ATTACHMENT_ID")
	long id;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name= "ATTACHMENT_IDS")
    private ClientMaster clientMaster;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Attachment [id=" + id + ", attachment=" + attachment + "]";
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Column(name="ATTACHMENT_NAME")
	String attachment;
	

}
