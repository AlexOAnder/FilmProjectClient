package Entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**Created by AlexOAnder 
 * 13.02.2016**/

public class CustomOrderView implements Serializable{
	public int OrderId;
	public int FilmId;
	public int CustomerId;
	public String FilmName;
	public String CustomerFirstName;
	public String CustomerLastName;
	public String PassportNumber;
	public Date Created;
	public Date RentExpires;
	public String PhoneNumber;
	public boolean Returned;
	public double TotalAmount;
	
	public CustomOrderView(){}
	
	public CustomOrderView(ResultSet rs) throws SQLException{
		
		OrderId = rs.getInt("OrderId");
		CustomerId = rs.getInt("CustomerId");
		FilmId = rs.getInt("FilmId");
		FilmName = rs.getString("FilmName");
		PhoneNumber = rs.getString("PhoneNumber");
		CustomerFirstName = rs.getString("FirstName");
		CustomerLastName = rs.getString("LastName");
		PassportNumber = rs.getString("PassportNumber");
		Created = rs.getDate("Created");
		RentExpires = rs.getDate("RentExpires");
		Returned = rs.getBoolean("Returned");
		TotalAmount = rs.getFloat("TotalAmount");
	}
} 
