package com.ms3.contactapi.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ms3.contactapi.model.Address;
import com.ms3.contactapi.model.Communication;
import com.ms3.contactapi.model.Identification;

public class ContactRequest {

	@JsonProperty("identification")
	private Identification identification;
	
	@JsonProperty("address")
	private List<Address> address;

	@JsonProperty("communication")
	private List<Communication> communication;
	
	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Communication> getCommunication() {
		return communication;
	}

	public void setCommunication(List<Communication> communication) {
		this.communication = communication;
	}
}
