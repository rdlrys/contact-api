package com.ms3.contactapi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenOperationIsValidThenReturnExpectedStatus() throws Exception {
		
		String payload = "{\"identification\": "
				+ "{ \"firstName\": \"Juan\", "
				+ "\"lastName\": \"Dela Cruz\", "
				+ "\"dateOfBirth\": \"01/01/2000\", "
				+ "\"gender\": \"M\", "
				+ "\"title\": \"Mr\"}}";
		
		String payload2 = "{\"identification\": "
				+ "{ \"firstName\": \"Pedro\", "
				+ "\"lastName\": \"Dela Cruz\", "
				+ "\"dateOfBirth\": \"01/01/2000\", "
				+ "\"gender\": \"M\", "
				+ "\"title\": \"Mr\"}}";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
				.content(payload)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/contacts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(302));
		
		mockMvc.perform(MockMvcRequestBuilders.put("/contacts/1")
				.content(payload2)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(202));
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/contacts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	}
	
	@Test
	public void whenRetrieveContactIsInvalidThenReturn404() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/contacts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(404));
	}
	
	@Test
	public void whenUpdateContactIsInvalidThenReturn404() throws Exception {
		String payload = "{\"identification\": "
				+ "{ \"firstName\": \"Juan\", "
				+ "\"lastName\": \"Dela Cruz\", "
				+ "\"dateOfBirth\": \"01/01/2000\", "
				+ "\"gender\": \"M\", "
				+ "\"title\": \"Mr\"}}";
		
		mockMvc.perform(MockMvcRequestBuilders.put("/contacts/1")
				.content(payload)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(404));
	}
	
	@Test
	public void whenDeleteContactIsInvalidThenReturn404() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/contacts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(404));
	}
}
