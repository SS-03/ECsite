package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserUpdateDAO {
	private DBConnector dbc = new DBConnector();
	private Connection con = dbc.getConnection();

	public int userDelete(String loginId,String loginPass) throws SQLException{
		String sql = "delete from login_user_transaction where login_id=? and login_pass=?";
		int result = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

	public int userUpdate(String loginId, String loginPass) throws SQLException{
		int result = 0;
		return result;
	}

}
