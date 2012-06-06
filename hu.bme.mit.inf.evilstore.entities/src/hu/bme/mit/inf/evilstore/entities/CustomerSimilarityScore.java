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
@Table(name="CustomerSimilarityScore_Table")
@XmlRootElement
public class CustomerSimilarityScore{
	
	@Id
	@GeneratedValue
	@Column(name="CustomerSimilarityScore_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected Long user1ID;
	public Long getUser1ID(){
		return this.user1ID;
	}
	public void setUser1ID(Long user1ID){
		this.user1ID = user1ID;
	}

	protected Long user2ID;
	public Long getUser2ID(){
		return this.user2ID;
	}
	public void setUser2ID(Long user2ID){
		this.user2ID = user2ID;
	}

	protected Double score;
	public Double getScore(){
		return this.score;
	}
	public void setScore(Double score){
		this.score = score;
	}
}
