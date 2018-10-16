package com.cg.project.bean;

import java.util.Arrays;

public class Associate {
	
	private int associateId;
	private String password,firstName,lastName,email,date;
	private String[] hobbies;
	
	
	public Associate() {
		super();
	}

	
	
	




public String getDate() {
		return date;
	}








	public void setDate(String date) {
		this.date = date;
	}








public Associate(int associateId, String password, String firstName,
			String lastName, String email, String date, String[] hobbies) {
		super();
		this.associateId = associateId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.hobbies = hobbies;
	}








public String getFirstName() {
	return firstName;
}




public void setFirstName(String firstName) {
	this.firstName = firstName;
}




public String getLastName() {
	return lastName;
}




public void setLastName(String lastName) {
	this.lastName = lastName;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String[] getHobbies() {
	return hobbies;
}




public void setHobbies(String[] hobbies) {
	this.hobbies = hobbies;
}




public Associate(int associateId, String password) {
		super();
		this.associateId = associateId;
		this.password = password;
	}




public int getAssociateId() {
	return associateId;
}

public void setAssociateId(int associateId) {
	this.associateId = associateId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + associateId;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + Arrays.hashCode(hobbies);
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Associate other = (Associate) obj;
	if (associateId != other.associateId)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (!Arrays.equals(hobbies, other.hobbies))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	return true;
}

@Override
public String toString() {
	return "Associate [associateId=" + associateId + ", password=" + password
			+ ", firstName=" + firstName + ", lastName=" + lastName
			+ ", email=" + email + ", date=" + date + ", hobbies="
			+ Arrays.toString(hobbies) + "]";
}


	
	
	

}
