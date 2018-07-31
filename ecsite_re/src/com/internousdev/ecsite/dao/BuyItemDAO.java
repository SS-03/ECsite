package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<BuyItemDTO> getBuyItemInfo(){
		ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

		String sql = "select id,item_name,item_price from item_info_transaction";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				BuyItemDTO dtoList = new BuyItemDTO();
				dtoList.setId(resultSet.getInt("id"));
				dtoList.setItemName(resultSet.getString("item_name"));
				dtoList.setItemPrice(resultSet.getString("item_price"));
				buyItemDTOList.add(dtoList);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTOList;
	}

	/*public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}*/

}
