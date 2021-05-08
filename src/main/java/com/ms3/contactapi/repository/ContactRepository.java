package com.ms3.contactapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms3.contactapi.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
