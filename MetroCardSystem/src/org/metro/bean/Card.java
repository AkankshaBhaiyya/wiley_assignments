package org.metro.bean;

public class Card {
	public Card()
	{
		
	}
	public Card(int id, String name, String swipeStatus, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.swipeStatus = swipeStatus;
		this.amount = amount;
	}
	private int id;
	private String name;
	private String swipeStatus;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSwipeStatus() {
		return swipeStatus;
	}
	public void setSwipeStatus(String swipeStatus) {
		this.swipeStatus = swipeStatus;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", swipeStatus=" + swipeStatus + ", amount=" + amount + "]";
	}
	
	

}
