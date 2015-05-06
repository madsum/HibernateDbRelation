package com.masum.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String publisherName;
    @Embedded
    private Address publisheAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public Address getPublisheAddress() {
		return publisheAddress;
	}
	public void setPublisheAddress(Address publisheAddress) {
		this.publisheAddress = publisheAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
     
}