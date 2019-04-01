package com.revature.service;

import java.util.List;

import com.revature.dto.Reimbursement;
import com.revature.impDao.ReimbImp;

public class ReimbService {
	
	private ReimbImp ri = new ReimbImp();
	
	public boolean insertReimb(double amount, String description,int authorId, int type) {
		Reimbursement reimb = new Reimbursement();
		reimb.setReimbAmount(amount);
		reimb.setReimbDescription(description);
		reimb.setReimbAuthor(authorId);
		reimb.setReimbType(type);
		return ri.insertReimbursement(reimb);
	}
	
	public List<Reimbursement> getAllReimbByUser(int userId){
		return ri.getReimbursementsByUser(userId);
	}
	
	

}
