package hu.bme.mit.inf.evilstore.entities;

import java.util.List;
import java.util.ArrayList;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Developer_Table")
@XmlRootElement
public class Developer{
	
	@Id
	@GeneratedValue
	@Column(name="Developer_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected List<Application> uploadedApplications = new ArrayList<Application>();
	public List<Application> getUploadedApplications(){
		return this.uploadedApplications;
	}
	public void setUploadedApplications(List<Application> uploadedApplications){
		this.uploadedApplications = uploadedApplications;
	}

	protected Account account;
	public Account getAccount(){
		return this.account;
	}
	public void setAccount(Account account){
		this.account = account;
	}

	protected String Name;
	public String getName(){
		return this.Name;
	}
	public void setName(String Name){
		this.Name = Name;
	}
}
