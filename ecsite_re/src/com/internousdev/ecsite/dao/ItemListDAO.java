package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private DBConnector dbc = new DBConnector();
	private Connection con = dbc.getConnection();

	public ArrayList<ItemListDTO> getItemListInfo() throws SQLException{
		ArrayList<ItemListDTO> itemList = new ArrayList<ItemListDTO>();
		String sql = "select * from item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while(res.next()){
				ItemListDTO itemDTO = new ItemListDTO();
				System.out.println("SQL");
				itemDTO.setItemId(res.getString("item_id"));
				itemDTO.setItemName(res.getString("item_name"));
				itemDTO.setItemPrices(res.getString("item_price"));
				itemDTO.setItemStock(res.getString("item_stock"));
				itemDTO.setInsertDate(res.getString("insert_date"));
				itemDTO.setUpdateDate(res.getString("update_date"));
				itemList.add(itemDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemList;
	}

}
