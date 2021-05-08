package com.ms3.contactapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="contact")
public class Contact {

	@JoinColumn
	@OneToOne(cascade = CascadeType.ALL)
	private Identification identification;

	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<Communication> communication;
	
	@Id
	@JsonIgnore
	@GeneratedValue
	@Column(name="id")	
	private int id;
	
	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identifcation) {
		this.identification = identifcation;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Communication> getCommunication() {
		return communication;
	}

	public void setCommunication(List<Communication> communication) {
		this.communication = communication;
	}
}
