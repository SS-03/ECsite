package com.internousdev.ecsite.dto;

public class UserListDTO {
	private String id;
	private String loginId;
	private String loginPassword;
	private String userName;
	private String insertDate;
	private String updatedDate;


	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(String insertDate){
		this.insertDate = insertDate;
	}
	public String getUpdatedDate(){
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate){
		this.updatedDate = updatedDate;
	}


}
