package com.pojo;

public class Problems {
	
	private int id;
	private String remark;
	/**
	 * @param id
	 * @param remark
	 */
	public Problems(int id, String remark) {
		super();
		this.id = id;
		this.remark = remark;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Problems [id=" + id + ", remark=" + remark + "]";
	}
	
	

}
