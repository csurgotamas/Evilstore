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
@Table(name="ApplicationDescription_Table")
@XmlRootElement
public class ApplicationDescription{
	
	@Id
	@GeneratedValue
	@Column(name="ApplicationDescription_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected String descriptionText;
	public String getDescriptionText(){
		return this.descriptionText;
	}
	public void setDescriptionText(String descriptionText){
		this.descriptionText = descriptionText;
	}

	protected List<String> applicationType = new ArrayList<String>();
	public List<String> getApplicationType(){
		return this.applicationType;
	}
	public void setApplicationType(List<String> applicationType){
		this.applicationType = applicationType;
	}

	protected Integer ageRestriction;
	public Integer getAgeRestriction(){
		return this.ageRestriction;
	}
	public void setAgeRestriction(Integer ageRestriction){
		this.ageRestriction = ageRestriction;
	}
}
