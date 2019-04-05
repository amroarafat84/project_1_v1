package com.revature.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.ReimDto;
import com.revature.dto.Reimbursement;
import com.revature.dto.User;
import com.revature.impDao.ImpUser;
import com.revature.impDao.ReimbImp;

public class ReimbService {
	
	private ReimbImp ri = new ReimbImp();
	private ImpUser user = new ImpUser();
	
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

	
	public List<ReimDto> getAllReimb(int userId){
		List<ReimDto> list = new ArrayList<>();
		
		List<Reimbursement> reimbs = getAllReimbByUser(userId);
		
		for(Reimbursement r : reimbs) {
			ReimDto rei = new ReimDto();
			rei.setReimbId(r.getReimbId());
			rei.setReimbAmount(r.getReimbAmount());
			rei.setReimbSubmitted(r.getReimbSubmitted());
			rei.setReimbResolved(r.getReimbResolved());
			rei.setReimbDescription(r.getReimbDescription());
			switch(r.getReimbType()) {
			case 1 : rei.setReimbType("Relocation"); break;
			case 2 : rei.setReimbType("Travel"); break;
			case 3 : rei.setReimbType("Training"); break;
			case 4 : rei.setReimbType("Other"); break;
			}
			switch(r.getStatus()) {
			case 1 : rei.setStatus("pending"); break;
			case 2 : rei.setStatus("approved"); break;
			case 3 : rei.setStatus("denied"); break;
			}
			User u = user.getUserById(r.getReimbResolver());
			rei.setRes_firstName(u.getFirstName());
			rei.setRes_lastName(u.getLastName());
			rei.setRes_email(u.getEmail());
			list.add(rei);
		}
		return list;
	}
	
	public List<ReimDto> getAllReimb(){
		List<ReimDto> list = new ArrayList<>();
		
		List<Reimbursement> reimbs = ri.getReimbursement();
		
		for(Reimbursement r : reimbs) {
			ReimDto rei = new ReimDto();
			rei.setReimbId(r.getReimbId());
			rei.setReimbAmount(r.getReimbAmount());
			rei.setReimbSubmitted(r.getReimbSubmitted());
			rei.setReimbResolved(r.getReimbResolved());
			rei.setReimbDescription(r.getReimbDescription());
			switch(r.getReimbType()) {
			case 1 : rei.setReimbType("Relocation"); break;
			case 2 : rei.setReimbType("Travel"); break;
			case 3 : rei.setReimbType("Training"); break;
			case 4 : rei.setReimbType("Other"); break;
			}
			switch(r.getStatus()) {
			case 1 : rei.setStatus("pending"); break;
			case 2 : rei.setStatus("approved"); break;
			case 3 : rei.setStatus("denied"); break;
			}
			User u = user.getUserById(r.getReimbResolver());
			rei.setRes_firstName(u.getFirstName());
			rei.setRes_lastName(u.getLastName());
			rei.setRes_email(u.getEmail());
			User a = user.getUserById(r.getReimbAuthor());
			rei.setAuth_firstName(a.getFirstName());
			rei.setAuth_lastName(a.getLastName());
			rei.setAuth_email(a.getEmail());
			list.add(rei);
		}
		return list;
	}
	
	public List<ReimDto> getAllReimbByStatus(int status){
		List<ReimDto> list = new ArrayList<>();
		
		List<Reimbursement> reimbs = ri.getReimbursement();
		
		for(Reimbursement r : reimbs) {
			ReimDto rei = new ReimDto();
			rei.setReimbId(r.getReimbId());
			rei.setReimbAmount(r.getReimbAmount());
			rei.setReimbSubmitted(r.getReimbSubmitted());
			rei.setReimbResolved(r.getReimbResolved());
			rei.setReimbDescription(r.getReimbDescription());
			switch(r.getReimbType()) {
			case 1 : rei.setReimbType("Relocation"); break;
			case 2 : rei.setReimbType("Travel"); break;
			case 3 : rei.setReimbType("Training"); break;
			case 4 : rei.setReimbType("Other"); break;
			}
			switch(r.getStatus()) {
			case 1 : rei.setStatus("pending"); break;
			case 2 : rei.setStatus("approved"); break;
			case 3 : rei.setStatus("denied"); break;
			}
			User u = user.getUserById(r.getReimbResolver());
			rei.setRes_firstName(u.getFirstName());
			rei.setRes_lastName(u.getLastName());
			rei.setRes_email(u.getEmail());
			User a = user.getUserById(r.getReimbAuthor());
			rei.setAuth_firstName(a.getFirstName());
			rei.setAuth_lastName(a.getLastName());
			rei.setAuth_email(a.getEmail());
			if(r.getStatus() == 1)
				list.add(rei);
			else if(r.getStatus() == 2)
				list.add(rei);
			else if(r.getStatus() == 3)
				list.add(rei);
		}
		return list;
	}
	
	public boolean approveReimb(User user, ReimDto temp) {
		return ri.update(user, temp, 2);
	}

	public boolean deniedReimb(User user, ReimDto temp) {
		return ri.update(user, temp, 3);
	}
}
