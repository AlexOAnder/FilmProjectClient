package Entities;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**Created by AlexOAnder 
 * 02.01.2016**/

// need for the SQL table
public class Order implements Serializable{
	private int _orderId;
	private int _filmId;
	private int _customerId;
	private int _employeeId;
	private Date _created;
	private Date _rentExpires;
	private String _phoneNumber;
	

	private boolean _returned;
	
	public Order(ResultSet rs) throws SQLException{
		
		_orderId = rs.getInt("OrderId");
		_filmId = rs.getInt("FilmId");
		_phoneNumber = rs.getString("PhoneNumber");
		_customerId = rs.getInt("CustomerId");
		_employeeId = rs.getInt("EmployeeId");
		_created = rs.getDate("Created");
		_rentExpires = rs.getDate("RentExpires");
		_returned = rs.getBoolean("Returned");
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return _orderId;
	}

	public void setOrderId(int orderId) {
		_orderId = orderId;
	}

	public int getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(int customerId) {
		_customerId = customerId;
	}

	public int getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(int employeeId) {
		_employeeId = employeeId;
	}

	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		_created = created;
	}

	public Date getRentExpires() {
		return _rentExpires;
	}

	public void setRentExpires(Date rentExpires) {
		_rentExpires = rentExpires;
	}

	public int getFilmId() {
		return _filmId;
	}

	public void setFilmId(int filmId) {
		_filmId = filmId;
	}

	public boolean isReturned() {
		return _returned;
	}

	public void setReturned(boolean returned) {
		_returned = returned;
	}

	public String get_phoneNumber() {
		return _phoneNumber;
	}

	public void set_phoneNumber(String _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}

}
