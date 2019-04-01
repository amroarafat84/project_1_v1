package com.revature.dto;

public class ReimbSubmit {
	
	private double amount;
	private String description;
	private int type;
	
	
	
	public ReimbSubmit() {
	}

	public ReimbSubmit(double amount, String description, int type) {
		super();
		this.amount = amount;
		this.description = description;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbSubmit [amount=" + amount + ", description=" + description + ", type=" + type + "]";
	}

	

}
