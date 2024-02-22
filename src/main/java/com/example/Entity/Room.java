package com.example.Entity;

import org.springframework.stereotype.Component;

@Component
public class Room {

	private int roomId;
	private int hotelId;
	private String hotelName;
	private String roomType;
	private int roomNumber;
	private int price;
	private boolean availability;
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelId=" + hotelId + ", hotelName=" + hotelName + ", roomType=" + roomType
				+ ", roomNumber=" + roomNumber + ", price=" + price + ", availability=" + availability + "]";
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
