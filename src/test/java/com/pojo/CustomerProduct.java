package com.pojo;

public class CustomerProduct {
	private String dop;
	private String serial_number;
	private String imei1;
	private String imei2;
	private String popurl;
	private int product_id;
	private int mst_model_id;

	/**
	 * @return the dop
	 */
	public String getDop() {
		return dop;
	}

	/**
	 * @param dop the dop to set
	 */
	public void setDop(String dop) {
		this.dop = dop;
	}

	/**
	 * @return the serial_number
	 */
	public String getSerial_number() {
		return serial_number;
	}

	/**
	 * @param serial_number the serial_number to set
	 */
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	/**
	 * @return the imei1
	 */
	public String getImei1() {
		return imei1;
	}

	/**
	 * @param imei1 the imei1 to set
	 */
	public void setImei1(String imei1) {
		this.imei1 = imei1;
	}

	/**
	 * @return the imei2
	 */
	public String getImei2() {
		return imei2;
	}

	/**
	 * @param imei2 the imei2 to set
	 */
	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}

	/**
	 * @return the popurl
	 */
	public String getPopurl() {
		return popurl;
	}

	/**
	 * @param popurl the popurl to set
	 */
	public void setPopurl(String popurl) {
		this.popurl = popurl;
	}

	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the mst_model_id
	 */
	public int getMst_model_id() {
		return mst_model_id;
	}

	/**
	 * @param mst_model_id the mst_model_id to set
	 */
	public void setMst_model_id(int mst_model_id) {
		this.mst_model_id = mst_model_id;
	}

	/**
	 * @param dop
	 * @param serial_number
	 * @param imei1
	 * @param imei2
	 * @param popurl
	 * @param product_id
	 * @param mst_model_id
	 */
	public CustomerProduct(String dop, String serial_number, String imei1, String imei2, String popurl, int product_id,
			int mst_model_id) {
		super();
		this.dop = dop;
		this.serial_number = serial_number;
		this.imei1 = imei1;
		this.imei2 = imei2;
		this.popurl = popurl;
		this.product_id = product_id;
		this.mst_model_id = mst_model_id;
	}

	@Override
	public String toString() {
		return "CustomerProduct [dop=" + dop + ", serial_number=" + serial_number + ", imei1=" + imei1 + ", imei2="
				+ imei2 + ", popurl=" + popurl + ", product_id=" + product_id + ", mst_model_id=" + mst_model_id + "]";
	}

}
