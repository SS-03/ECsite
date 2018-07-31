package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;

	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();


	public String execute(){
		String result=ERROR;

			//リロードしたときにエラーメッセージを残さないように一度消す
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");

			//入力された文字を判定し、正規表現でないならエラメッセージを返す
		InputChecker icheck = new InputChecker();
		loginIdErrorMessageList = icheck.doCheck("ログインID", loginUserId,1,8,true,false,false,true,false,false,false);
		passwordErrorMessageList = icheck.doCheck("パスワード", loginPassword, 1, 15, true,false,false,true,false,false,false);
		session.put("loginIdErrorMessageList", loginIdErrorMessageList);
		session.put("passwordErrorMessageList", passwordErrorMessageList);

			//エラメッセージリストになにかしら入っているならば、入力画面に留まる
		if(!loginIdErrorMessageList.isEmpty() || !passwordErrorMessageList.isEmpty()){
			return result;
		}

			//ログイン
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);
		System.out.println(loginUserId);
		System.out.println(loginPassword);

			//管理者かどうかを判断する
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){

			if(((LoginDTO) session.get("loginUser")).getLoginId().equals("master")
					&& ((LoginDTO) session.get("loginUser")).getLoginPassword().equals("master01")){

				result = "master";
				return result;

			}

		/*if(loginDTO.equals(null)){
			session.put("passwordCheckMessage", "入力されたID、もしくはパスワードが異なります。");
			return result;
		}*/

			result=SUCCESS;

			buyItemDTOList = buyItemDAO.getBuyItemInfo();

			return result;

		}

		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}
	public void getBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList){
		this.buyItemDTOList = buyItemDTOList;
	}



}
