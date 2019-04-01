package com.revature.impDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connectionutil.ConnectionFactory;
import com.revature.dao.ReimbursementDao;
import com.revature.dto.Reimbursement;

public class ReimbImp implements ReimbursementDao {
	
	public  Connection conn = ConnectionFactory.getInstance().getConnection();

	@Override
	public List<Reimbursement> getReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursementByUser(int Userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursement(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertReimbursement(Reimbursement reimb) {
		String sql = "insert into ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_TYPE_ID) "
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimb.getReimbAmount());
			ps.setString(2, reimb.getReimbDescription());
			ps.setInt(3, reimb.getReimbAuthor());
			ps.setInt(4, reimb.getReimbType());
			return ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void update(Reimbursement reimbursement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}
	
	/*
--     REIMB_ID  	integer 	not null 	primary key 	auto_increment ,
--     REIMB_AMOUNT  	decimal (8,2) ,
--     REIMB_SUBMITTED  	timestamp  default  CURRENT_TIMESTAMP,
--     REIMB_RESOLVED  	timestamp ,
--     REIMB_DESCRIPTION  	VARCHAR(250) ,
--     REIMB_BLOB  	BLOB ,
--     REIMB_AUTHOR  	INT ,
--     REIMB_RESOLVER  	INT ,
--     REIMB_STATUS_ID		INT default 1,
--     REIMB_TYPE_ID		INT,
	 */

	@Override
	public List<Reimbursement> getReimbursementsByUser(int userId) {
		String sql = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR = ?";
		List<Reimbursement> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setReimbAmount(rs.getDouble(2));
				r.setReimbSubmitted(rs.getDate(3));
				r.setReimbResolved(rs.getDate(4));
				r.setReimbDescription(rs.getString(5));
				r.setReimbAuthor(rs.getInt(6));
				r.setReimbResolver(rs.getInt(7));
				r.setStatus(rs.getInt(8));
				r.setReimbType(rs.getInt(9));
				list.add(r);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
