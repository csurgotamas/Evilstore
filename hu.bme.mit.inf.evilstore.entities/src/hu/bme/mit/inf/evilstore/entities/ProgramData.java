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
@Table(name="ProgramData_Table")
@XmlRootElement
public class ProgramData{
	
	@Id
	@GeneratedValue
	@Column(name="ProgramData_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	protected String programFile;
	public String getProgramFile(){
		return this.programFile;
	}
	public void setProgramFile(String programFile){
		this.programFile = programFile;
	}
}
