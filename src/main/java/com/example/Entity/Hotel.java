package com.example.Entity;

import org.springframework.stereotype.Component;

@Component
public class Hotel{
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int hotelId;
	private String hotelName;
	private String location;
	private String ownerId;
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return this.hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", location=" + location + ", ownerId="
				+ ownerId + "]";
	}
	public String getOwnerId() {
		return this.ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public Hotel(int hotelId, String hotelName, String location, String ownerId) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.location = location;
		this.ownerId = ownerId;
	}
	
}