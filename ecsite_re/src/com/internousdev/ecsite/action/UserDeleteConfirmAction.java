package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport implements SessionAware{
	private int id;
	public Map<String, Object> session;
	private UserListDAO userListDAO = new UserListDAO();
	private UserListDTO userListDTO = new UserListDTO();

	public String execute() throws SQLException{

		userListDTO = userListDAO.getUserInfo(id);

		session.put("id", userListDTO.getId());
		session.put("loginId", userListDTO.getLoginId());
		session.put("loginPass", userListDTO.getLoginPassword());
		session.put("userName", userListDTO.getUserName());
		session.put("insertDate", userListDTO.getInsertDate());
		session.put("updateDate", userListDTO.getUpdatedDate());

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}


}
