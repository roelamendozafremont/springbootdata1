package com.mendoza.people.mngt.appqueryanno.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="persontable")
@DynamicUpdate

@NamedQueries(value = { 
		@NamedQuery(name = "Person.findLikefirstname", query = "SELECT p FROM Person p WHERE p.firstname LIKE ?1"),
		@NamedQuery(name = "Person.findLikelastname", query = "SELECT p FROM Person p WHERE p.lastname LIKE ?1"),		
		@NamedQuery(name = "Person.findLikefirstAndlastname", query = "SELECT p FROM Person p WHERE p.firstname LIKE ?1 AND p.lastname LIKE ?2") 		
		})

@NamedNativeQueries(value = { 
		@NamedNativeQuery(name = "Person.findLikefirstname2", query = "SELECT * FROM persontable WHERE pfirstname LIKE ?1",resultClass=Person.class),
		@NamedNativeQuery(name = "Person.findLikefirstAndlastname2", query = "SELECT * FROM persontable WHERE pfirstname LIKE ?1 AND plastname LIKE ?2",resultClass=Person.class) 		
		})


public class Person {
	

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private int id;
	
	@Column(name="pfirstname",length=60,nullable=false)
	private String firstname;
	
	@Column(name="plastname",length=60,nullable=false)
	private String lastname;
	
	@Column(name="psexcode",length=60,nullable=true)
	private String sexcode;
	
	@Column(name="pbirthyear",length=60,nullable=true)
	private String birthyear;
	
	@Id
	@Column(name="pemailid",length=60,unique=true)
	private String emailid;

	@Column(name="pmothersname",length=60,nullable=true)
	private String mothersname;
	
	@Column(name="pfathersname",length=60,nullable=true)
	private String fathersname;
	
	@Column(name="pcreationdate")
	private Date creationdate;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String firstname, String lastname, String emailid) {
		super();
		this.setId(new Random().nextInt(1000));
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.creationdate = new Date();
	}
	
	
	public Person(String firstname, String lastname, String sexcode, String birthyear,
			String fathersname, String mothersname, String emailid) {
		super();
		this.setId(new Random().nextInt(1000));
		this.creationdate = new Date();		
		this.firstname = firstname;
		this.lastname = lastname;
		this.sexcode = sexcode;
		this.birthyear = birthyear;
		this.emailid = emailid;
		this.mothersname = mothersname;
		this.fathersname = fathersname;
	}

	public String getSexcode() {
		return sexcode;
	}


	public void setSexcode(String sexcode) {
		this.sexcode = sexcode;
	}


	public String getBirthyear() {
		return birthyear;
	}


	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}


	public String getMothersname() {
		return mothersname;
	}


	public void setMothersname(String mothersname) {
		this.mothersname = mothersname;
	}


	public String getFathersname() {
		return fathersname;
	}


	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}
	public int getId() {
		return id;
	}
 	public void setId(int id) {
 		this.id = id;
 	}
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

	public String returnPrintString() {
		return this.getLastname()+", "+this.getFirstname()+" "+this.getBirthyear()+" "+this.getFathersname()+"/"+
			this.getMothersname()+" "+this.getEmailid()+" "+this.getSexcode();
	}
	
}
