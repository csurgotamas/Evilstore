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
@Table(name="Account_Table")
@XmlRootElement
public class Account{
	
	@Id
	@GeneratedValue
	@Column(name="Account_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected String accountId;
	public String getAccountId(){
		return this.accountId;
	}
	public void setAccountId(String accountId){
		this.accountId = accountId;
	}

	protected Integer cash;
	public Integer getCash(){
		return this.cash;
	}
	public void setCash(Integer cash){
		this.cash = cash;
	}
}
