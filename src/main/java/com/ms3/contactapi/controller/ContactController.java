package com.ms3.contactapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms3.contactapi.dao.ContactRequest;
import com.ms3.contactapi.model.Contact;
import com.ms3.contactapi.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping(value = "/contacts", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Integer> createContact(@RequestBody ContactRequest contactRequest){
		int contactId = contactService.createContact(contactRequest);
		return new ResponseEntity<>(contactId, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/contacts/{id}")
	public ResponseEntity<Contact> retrieveContact(@PathVariable int id){
		Contact contact = contactService.retrieveContact(id);
		if(contact == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact, HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/contacts/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> updateContact(@PathVariable int id, @RequestBody ContactRequest contactRequest){
		int result = contactService.updateContact(id, contactRequest);
		if(result == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/contacts/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable int id){
		int result = contactService.deleteContact(id);
		if(result == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
