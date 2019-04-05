package com.revature.dao;

import java.util.List;

import com.revature.dto.ReimDto;
import com.revature.dto.Reimbursement;
import com.revature.dto.User;

public interface ReimbursementDao {
	
	// Retrieve all Reimbursements from Reimbursement table 
	public List<Reimbursement> getReimbursement();
	
	// Retrieve all Reimbursements from Reimbursement table for user 
	public List<Reimbursement> getReimbursementsByUser(int userId);
	
	// Retrieve a Reimbursement by id from Reimbursement table
	public Reimbursement getReimbursementByUser(int Userid);
	
	
	// retrieve a Reimbursement by name from Reimbursement table
	public Reimbursement getReimbursement(String name);
	
	
	// insert a Reimbursement into Reimbursement table
	public boolean insertReimbursement(Reimbursement reimb);
	
	
	// update Reimbursement info
	public boolean update(User user, ReimDto temp,int flag);
	
	
	// delete Reimbursement using a Reimbursement id
	public void delete(int id);

}
