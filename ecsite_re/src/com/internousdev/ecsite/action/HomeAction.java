package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public String execute(){

		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");

		String result = "login";
		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();

			buyItemDTOList = buyItemDAO.getBuyItemInfo();

			result=SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return this.session;
	}
	public ArrayList<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}
	public void getBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList){
		this.buyItemDTOList = buyItemDTOList;
	}

}
