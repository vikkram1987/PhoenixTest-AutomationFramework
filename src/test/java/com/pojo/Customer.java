package com.pojo;

public class Customer {
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String mobile_number_alt;
	private String email_id;
	private String email_id_alt;

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the mobile_number
	 */
	public String getMobile_number() {
		return mobile_number;
	}

	/**
	 * @param mobile_number the mobile_number to set
	 */
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	/**
	 * @return the mobile_number_alt
	 */
	public String getMobile_number_alt() {
		return mobile_number_alt;
	}

	/**
	 * @param mobile_number_alt the mobile_number_alt to set
	 */
	public void setMobile_number_alt(String mobile_number_alt) {
		this.mobile_number_alt = mobile_number_alt;
	}

	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}

	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	/**
	 * @return the email_id_alt
	 */
	public String getEmail_id_alt() {
		return email_id_alt;
	}

	/**
	 * @param email_id_alt the email_id_alt to set
	 */
	public void setEmail_id_alt(String email_id_alt) {
		this.email_id_alt = email_id_alt;
	}

	/**
	 * @param first_name
	 * @param last_name
	 * @param mobile_number
	 * @param mobile_number_alt
	 * @param email_id
	 * @param email_id_alt
	 */
	public Customer(String first_name, String last_name, String mobile_number, String mobile_number_alt,
			String email_id, String email_id_alt) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.mobile_number_alt = mobile_number_alt;
		this.email_id = email_id;
		this.email_id_alt = email_id_alt;
	}

	@Override
	public String toString() {
		return "Customer [first_name=" + first_name + ", last_name=" + last_name + ", mobile_number=" + mobile_number
				+ ", mobile_number_alt=" + mobile_number_alt + ", email_id=" + email_id + ", email_id_alt="
				+ email_id_alt + "]";
	}

}
