package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private String deleteFlg;
	private String message;
	private String result;

	public String execute() throws SQLException{

		if(deleteFlg == null){
			userList = userListDAO.getUserListInfo();
			result = SUCCESS;
		}else if(deleteFlg.equals("1")){
			delete();
			result = "delete";
		}

		return result;
	}

	public void delete() throws SQLException{

		String loginId = session.get("loginId").toString();
		String loginPass = session.get("loginPass").toString();

		int res = userListDAO.userDelete(loginId, loginPass);

		if(res > 0){
			setMessage("削除しました。");
		}else if(res == 0){
			setMessage("削除できませんでした。");
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<UserListDTO> getUserList(){
		return userList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}
}
