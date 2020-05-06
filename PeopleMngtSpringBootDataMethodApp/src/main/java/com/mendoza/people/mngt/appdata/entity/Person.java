package com.mendoza.people.mngt.appdata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="persontable")
@DynamicUpdate
public class Person {
	

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private int id;
	
	@Column(name="pfirstname",length=60,nullable=false)
	private String firstname;
	
	@Column(name="plastname",length=60,nullable=false)
	private String lastname;
	
	@Id
	@Column(name="pemailid",length=60,unique=true)
	private String emailid;
	
	@Column(name="pcreationdate")
	private Date creationdate;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String firstname, String lastname, String emailid, Date creationdate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.creationdate = creationdate;
	}
	
	
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	
	
}
