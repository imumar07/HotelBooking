package com.example.Entity;

public class Payment {

	private String cardNumber;
	private String cardName;
	private int cvv;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Payment(String cardNumber, String cardName, int cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "Payment [cardNumber=" + cardNumber + ", cardName=" + cardName + ", cvv=" + cvv + "]";
	}

}
