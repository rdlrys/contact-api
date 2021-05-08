package com.ms3.contactapi.service;

import org.springframework.stereotype.Service;

import com.ms3.contactapi.dao.ContactRequest;
import com.ms3.contactapi.model.Contact;

@Service
public interface ContactService {

	int createContact(ContactRequest contact);
	Contact retrieveContact(int contactId);
	int updateContact(int id, ContactRequest contact);
	int deleteContact(int contactId);
}
