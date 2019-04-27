package com.gyf.bookstore.domain;




public class Sell {

	private String id;
	private String sellAddress;
	private String sellName;
	private String sellPhone;
	private String sellBook;
	private User user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSellAddress() {
		return sellAddress;
	}
	public void setSellAddress(String sellAddress) {
		this.sellAddress = sellAddress;
	}
	public String getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	public String getSellPhone() {
		return sellPhone;
	}
	public void setSellPhone(String sellPhone) {
		this.sellPhone = sellPhone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSellBook() {
		return sellBook;
	}
	public void setSellBook(String sellBook) {
		this.sellBook = sellBook;
	}
	
	
	

}
