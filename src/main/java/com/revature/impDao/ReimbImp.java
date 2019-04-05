package com.revature.impDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.connectionutil.ConnectionFactory;
import com.revature.dao.ReimbursementDao;
import com.revature.dto.ReimDto;
import com.revature.dto.Reimbursement;
import com.revature.dto.User;

public class ReimbImp implements ReimbursementDao {
	
	public  Connection conn = ConnectionFactory.getInstance().getConnection();

	@Override
	public List<Reimbursement> getReimbursement() {
		String sql = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR";
		List<Reimbursement> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setReimbAmount(rs.getDouble(2));
				r.setReimbSubmitted(rs.getDate(3));
				r.setReimbResolved(rs.getDate(4));
				r.setReimbDescription(rs.getString(5));
				r.setReimbAuthor(rs.getInt(7));
				r.setReimbResolver(rs.getInt(8));
				r.setStatus(rs.getInt(9));
				r.setReimbType(rs.getInt(10));
				list.add(r);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
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
	public boolean update(User user, ReimDto temp, int flag) {
		String sql = "update ERS_REIMBURSEMENT set REIMB_RESOLVER = ?,"
						+ " REIMB_STATUS_ID = ?, "
						+ " REIMB_RESOLVED = CURRENT_DATE() "
						+ "where REIMB_ID = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, flag);
			ps.setInt(3, temp.getReimbId());
			return ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
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
				r.setReimbAuthor(rs.getInt(7));
				r.setReimbResolver(rs.getInt(8));
				r.setStatus(rs.getInt(9));
				r.setReimbType(rs.getInt(10));
				list.add(r);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
