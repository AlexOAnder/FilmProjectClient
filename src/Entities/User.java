package Entities;

import java.io.Serializable;

/**Created by AlexOAnder 
 * 02.01.2016**/

public class User implements Serializable{

	private String _firstName;
	private String _lastName;
	
	public final String getFirstName() {
		return _firstName;
	}
	public final void setFirstName(String firstName) {
		_firstName = firstName;
	}
	public final String getLastName() {
		return _lastName;
	}
	public final void setLastName(String lastName) {
		_lastName = lastName;
	}
} 
