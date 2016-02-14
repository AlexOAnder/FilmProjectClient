package Entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Created by AlexOAnder 
 * 02.01.2016**/

public class Customer extends User implements Serializable{

	private int _customerId;
	private String _passportNumber;
	private int _discount;
	private String _phoneNumber;
	public Customer(){}
	// constructor for the mapping
	public Customer(ResultSet rs) throws SQLException	{
		setCustomerId(rs.getInt("CustomerId"));
		setFirstName(rs.getString("FirstName"));
		setLastName(rs.getString("LastName"));
		setPassportNumber(rs.getString("PassportNumber"));
		setDiscount(rs.getInt("Discount"));
		setPhoneNumber(rs.getString("PhoneNumber"));
	}
	@Override
	public String toString(){
		String res = " CustomerId:"+getCustomerId()+" \n"
				+" FirstName: "+getFirstName()+" \n"
				+" LastName: "+getLastName()+" \n"
				+" PassportNumber: "+getPassportNumber()+" \n"
				+" Discount: "+getDiscount()+" \n"
				+" PhoneNumber: "+getPhoneNumber()+" \n"
				+"###############################\n";
		return res;
	}
	public String getPassportNumber() {
		return _passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		_passportNumber = passportNumber;
	}
	public int getDiscount() {
		return _discount;
	}
	public void setDiscount(int discount) {
		_discount = discount;
	}
	public int getCustomerId() {
		return _customerId;
	}
	public void setCustomerId(int customerId) {
		this._customerId = customerId;
	}
	public String getPhoneNumber() {
		return _phoneNumber;
	}
	public void setPhoneNumber(String _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}
}
