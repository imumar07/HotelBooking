package com.example.Entity;
import java.sql.Date;

public class Booking {
	private int bookingId;
	private String username;
	private int userId;
	private Date checkInDate;
	private Date checkOutDate;
	private String hotelName;
	private String location;
	private int hotelId;
	private String status;
	private int price;
	private String roomType;
	private int roomNumber;
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userName=" + username + ", userId=" + userId + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", hotelName=" + hotelName + ", location=" + location
				+ ", hotelId=" + hotelId + ", status=" + status + ", price=" + price + ", roomType=" + roomType
				+ ", roomNumber=" + roomNumber + "]";
	}
	public Booking(int bookingId, String username, int userId, Date checkInDate, Date checkOutDate, String hotelName,
			String location, int hotelId, String status, int price, String roomType, int roomNumber) {
		super();
		this.bookingId = bookingId;
		this.username = username;
		this.userId = userId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.hotelName = hotelName;
		this.location = location;
		this.hotelId = hotelId;
		this.status = status;
		this.price = price;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	
	
	

}
