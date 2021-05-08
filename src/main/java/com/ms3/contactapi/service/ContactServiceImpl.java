package com.ms3.contactapi.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms3.contactapi.dao.ContactRequest;
import com.ms3.contactapi.model.Contact;
import com.ms3.contactapi.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository; 
	
	@Override
	public int createContact(ContactRequest contactRequest) {
		Contact contact = new Contact();
		contact.setIdentification(contactRequest.getIdentification());
		contact.setAddress(contactRequest.getAddress());
		contact.setCommunication(contactRequest.getCommunication());
		contactRepository.save(contact);
		return contact.getId();
	}

	@Override
	public Contact retrieveContact(int contactId) {
		
		Contact contact = null;
		try {
			contact = Optional.ofNullable(contactRepository.findById(contactId).get()).orElse(null);
		} catch(NoSuchElementException | IllegalArgumentException e) {
			//log exception
			return null;
		}
		
		return contact;
	}

	@Override
	public int updateContact(int id, ContactRequest contactRequest) {
		try {
			Contact contact = contactRepository.findById(id).get();
			contact.setAddress(contactRequest.getAddress());
			contact.setCommunication(contactRequest.getCommunication());
			contact.setIdentification(contactRequest.getIdentification());
			contactRepository.save(contact);
		} catch(Exception e) {
			//log exception
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteContact(int contactId) {
		try {
			contactRepository.deleteById(contactId);
		} catch(Exception e) {
			//log exception
			return 0;
		}
		return 1;
	}
}
