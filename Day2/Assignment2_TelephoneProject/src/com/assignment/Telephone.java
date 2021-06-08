package com.assignment;

public class Telephone implements Comparable<Telephone>{
	private String name;
	private Long phoneNumber;
	private String address;
	public Telephone(String name, Long phoneNumber, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected Long getPhoneNumber() {
		return phoneNumber;
	}
	protected void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	protected String getAddress() {
		return address;
	}
	protected void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Telephone other = (Telephone) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Telephone [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	public int compareTo(Telephone telephone2) {
		String name1= this.getName();
		String name2=telephone2.getName();
		return name1.compareTo(name2);
	}
	
	

}
