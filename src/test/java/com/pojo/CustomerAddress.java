package com.pojo;

public class CustomerAddress {
	private String flat_number;
	private String apartment_name;
	private String street_name;
	private String landmark;
	private String area;
	private String pincode;
	private String country;
	private String state;
	/**
	 * @param flat_number
	 * @param apartment_name
	 * @param street_name
	 * @param landmark
	 * @param area
	 * @param pincode
	 * @param country
	 * @param state
	 */
	public CustomerAddress(String flat_number, String apartment_name, String street_name, String landmark, String area,
			String pincode, String country, String state) {
		super();
		this.flat_number = flat_number;
		this.apartment_name = apartment_name;
		this.street_name = street_name;
		this.landmark = landmark;
		this.area = area;
		this.pincode = pincode;
		this.country = country;
		this.state = state;
	}
	/**
	 * @return the flat_number
	 */
	public String getFlat_number() {
		return flat_number;
	}
	/**
	 * @param flat_number the flat_number to set
	 */
	public void setFlat_number(String flat_number) {
		this.flat_number = flat_number;
	}
	/**
	 * @return the apartment_name
	 */
	public String getApartment_name() {
		return apartment_name;
	}
	/**
	 * @param apartment_name the apartment_name to set
	 */
	public void setApartment_name(String apartment_name) {
		this.apartment_name = apartment_name;
	}
	/**
	 * @return the street_name
	 */
	public String getStreet_name() {
		return street_name;
	}
	/**
	 * @param street_name the street_name to set
	 */
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}
	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerAddress [flat_number=" + flat_number + ", apartment_name=" + apartment_name + ", street_name="
				+ street_name + ", landmark=" + landmark + ", area=" + area + ", pincode=" + pincode + ", country="
				+ country + ", state=" + state + "]";
	}
	
	
	
	
	
}
