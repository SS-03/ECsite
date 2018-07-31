package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	private DBConnector dbc = new DBConnector();
	private Connection con = dbc.getConnection();

	public ArrayList<UserListDTO> getUserListInfo() throws SQLException{
		ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
		String sql = "select * from login_user_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while(res.next()){

				UserListDTO dto = new UserListDTO();
				dto.setId(res.getString("id"));
				dto.setLoginId(res.getString("login_id"));
				dto.setLoginPassword(res.getString("login_pass"));
				dto.setUserName(res.getString("user_name"));
				dto.setInsertDate(res.getString("insert_date"));
				dto.setUpdatedDate(res.getString("updated_date"));
				userList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return userList;
	}

	public UserListDTO getUserInfo(int id) throws SQLException{

		String sql  = "select * from login_user_transaction where id=?";
		UserListDTO userListDTO = new UserListDTO();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();

			if(res.next()){
				userListDTO.setId(res.getString("id"));
				userListDTO.setLoginId(res.getString("login_id"));
				userListDTO.setLoginPassword(res.getString("login_pass"));
				userListDTO.setUserName(res.getString("user_name"));
				userListDTO.setInsertDate(res.getString("insert_date"));
				userListDTO.setUpdatedDate(res.getString("updated_date"));
				System.out.println("SQL実行OK");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return userListDTO;
	}

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

}
