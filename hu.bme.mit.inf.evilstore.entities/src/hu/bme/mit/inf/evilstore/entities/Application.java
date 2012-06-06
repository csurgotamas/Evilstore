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
@Table(name="Application_Table")
@XmlRootElement
public class Application{
	
	@Id
	@GeneratedValue
	@Column(name="Application_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected String applicationName;
	public String getApplicationName(){
		return this.applicationName;
	}
	public void setApplicationName(String applicationName){
		this.applicationName = applicationName;
	}

	protected Long developerId;
	public Long getDeveloperId(){
		return this.developerId;
	}
	public void setDeveloperId(Long developerId){
		this.developerId = developerId;
	}

	protected Integer version;
	public Integer getVersion(){
		return this.version;
	}
	public void setVersion(Integer version){
		this.version = version;
	}

	protected ApplicationDescription description;
	public ApplicationDescription getDescription(){
		return this.description;
	}
	public void setDescription(ApplicationDescription description){
		this.description = description;
	}

	protected Integer cost;
	public Integer getCost(){
		return this.cost;
	}
	public void setCost(Integer cost){
		this.cost = cost;
	}

	protected Long programDataID;
	public Long getProgramDataID(){
		return this.programDataID;
	}
	public void setProgramDataID(Long programDataID){
		this.programDataID = programDataID;
	}

	protected Boolean validated;
	public Boolean getValidated(){
		return this.validated;
	}
	public void setValidated(Boolean validated){
		this.validated = validated;
	}

	protected Boolean checked;
	public Boolean getChecked(){
		return this.checked;
	}
	public void setChecked(Boolean checked){
		this.checked = checked;
	}
}
