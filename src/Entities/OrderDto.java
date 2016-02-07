package Entities;

import java.io.Serializable;
import java.util.Date;
// need for representation of the Order's object

/**Created by AlexOAnder 
 * 02.01.2016**/

public class OrderDto implements Serializable{

	private int _orderId;
	private Customer _customer;
	private Employee _employee;
	private Date _created;
	private Date _rentFrom;
	private Date _rentExpires;
	
	public int getOrderId() {
		return _orderId;
	}
	public void setOrderId(int orderId) {
		this._orderId = orderId;
	}
	public Customer getCustomer() {
		return _customer;
	}
	public void setCustomer(Customer customer) {
		this._customer = customer;
	}
	public Employee getEmployee() {
		return _employee;
	}
	public void setEmployee(Employee employee) {
		this._employee = employee;
	}
	public Date getCreated() {
		return _created;
	}
	public void setCreated(Date created) {
		this._created = created;
	}
	public Date getRentFrom() {
		return _rentFrom;
	}
	public void setRentFrom(Date rentFrom) {
		this._rentFrom = rentFrom;
	}
	public Date getRentExpires() {
		return _rentExpires;
	}
	public void setRentExpires(Date rentExpires) {
		this._rentExpires = rentExpires;
	}
	
}
