package com.IZI.rest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class FeedData extends DatabaseAccess {


	public FeedData() {
		super();
		accessDatabase();
	}

	


	public static String[] readDatabaseForReorder() {
		accessDatabase();
		String[] produceReorder = new String[2];
		String sqlTemplate = "SELECT * from Feed Where OnReorder < 1";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			int recordAt = 0 ;
			while (rs.next()) {
				int feed_ID = rs.getInt("Feed_ID");
				int quantity_Left = rs.getInt("Quantity_Left");
				int reorder_Quanty = rs.getInt("Reorder_Quanty");
				String feed_Name = rs.getString("Feed_Name");
				String note = rs.getString("note");
				if(quantity_Left < reorder_Quanty) {
					
					updateDatabaseForQuantity(String.valueOf(feed_ID));
					produceReorder[0] = feed_Name;
					produceReorder[1] = note;
					return produceReorder;
				}

	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void updateDatabaseForQuantity(String feed_ID) {
		PreparedStatement preparedStatement = null;
		String sqlTemplate = "select * from Feed where Feed_ID  is "+feed_ID+" limit 1";
		try {

			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				String id = rs.getString("Feed_ID");

				String updateTableSQL = "UPDATE Feed SET OnReorder = 1 WHERE P_ID = ?";
				preparedStatement = connection.prepareStatement(updateTableSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
}
