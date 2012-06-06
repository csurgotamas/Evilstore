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
@Table(name="User_Table")
@XmlRootElement
public class User{
	
	@Id
	@GeneratedValue
	@Column(name="User_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected String userName;
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	protected Integer passwordHash;
	public Integer getPasswordHash(){
		return this.passwordHash;
	}
	public void setPasswordHash(Integer passwordHash){
		this.passwordHash = passwordHash;
	}

	protected Long birth;
	public Long getBirth(){
		return this.birth;
	}
	public void setBirth(Long birth){
		this.birth = birth;
	}

	protected Account account;
	public Account getAccount(){
		return this.account;
	}
	public void setAccount(Account account){
		this.account = account;
	}

	protected List<Purchase> purchasedApplications = new ArrayList<Purchase>();
	public List<Purchase> getPurchasedApplications(){
		return this.purchasedApplications;
	}
	public void setPurchasedApplications(List<Purchase> purchasedApplications){
		this.purchasedApplications = purchasedApplications;
	}
}
