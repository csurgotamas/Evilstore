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
@Table(name="Purchase_Table")
@XmlRootElement
public class Purchase{
	
	@Id
	@GeneratedValue
	@Column(name="Purchase_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected Integer atPrice;
	public Integer getAtPrice(){
		return this.atPrice;
	}
	public void setAtPrice(Integer atPrice){
		this.atPrice = atPrice;
	}

	protected Long date;
	public Long getDate(){
		return this.date;
	}
	public void setDate(Long date){
		this.date = date;
	}

	protected Application application;
	public Application getApplication(){
		return this.application;
	}
	public void setApplication(Application application){
		this.application = application;
	}
}
