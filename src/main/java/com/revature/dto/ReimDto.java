package com.revature.dto;

import java.sql.Date;

public class ReimDto {
	
	private int reimbId;
	private double reimbAmount;
	private Date reimbSubmitted;
	private Date reimbResolved;
	private String reimbDescription;
	private String auth_firstName;
	private String auth_lastName;
	private String auth_email;
	private String res_firstName;
	private String res_lastName;
	private String res_email;
	private String status;
	private String reimbType;
	
	
	public ReimDto() {
	
	}


	public ReimDto(int reimbId, double reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription,
			String auth_firstName, String auth_lastName, String auth_email, String res_firstName, String res_lastName,
			String res_email, String status, String reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.auth_firstName = auth_firstName;
		this.auth_lastName = auth_lastName;
		this.auth_email = auth_email;
		this.res_firstName = res_firstName;
		this.res_lastName = res_lastName;
		this.res_email = res_email;
		this.status = status;
		this.reimbType = reimbType;
	}


	public int getReimbId() {
		return reimbId;
	}


	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}


	public double getReimbAmount() {
		return reimbAmount;
	}


	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}


	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}


	public void setReimbSubmitted(Date reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}


	public Date getReimbResolved() {
		return reimbResolved;
	}


	public void setReimbResolved(Date reimbResolved) {
		this.reimbResolved = reimbResolved;
	}


	public String getReimbDescription() {
		return reimbDescription;
	}


	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}


	public String getAuth_firstName() {
		return auth_firstName;
	}


	public void setAuth_firstName(String auth_firstName) {
		this.auth_firstName = auth_firstName;
	}


	public String getAuth_lastName() {
		return auth_lastName;
	}


	public void setAuth_lastName(String auth_lastName) {
		this.auth_lastName = auth_lastName;
	}


	public String getAuth_email() {
		return auth_email;
	}


	public void setAuth_email(String auth_email) {
		this.auth_email = auth_email;
	}


	public String getRes_firstName() {
		return res_firstName;
	}


	public void setRes_firstName(String res_firstName) {
		this.res_firstName = res_firstName;
	}


	public String getRes_lastName() {
		return res_lastName;
	}


	public void setRes_lastName(String res_lastName) {
		this.res_lastName = res_lastName;
	}


	public String getRes_email() {
		return res_email;
	}


	public void setRes_email(String res_email) {
		this.res_email = res_email;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReimbType() {
		return reimbType;
	}


	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}


	@Override
	public String toString() {
		return "ReimDto [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription + ", auth_firstName="
				+ auth_firstName + ", auth_lastName=" + auth_lastName + ", auth_email=" + auth_email
				+ ", res_firstName=" + res_firstName + ", res_lastName=" + res_lastName + ", res_email=" + res_email
				+ ", status=" + status + ", reimbType=" + reimbType + "]";
	}
	
	
	


}
