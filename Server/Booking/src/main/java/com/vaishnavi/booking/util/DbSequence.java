package com.vaishnavi.booking.util;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class DbSequence {
	
	@Id
	private String id;
	private int sequenceNumber;

	public DbSequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DbSequence(String id, int sequenceNumber) {
		super();
		this.id = id;
		this.sequenceNumber = sequenceNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	

}
