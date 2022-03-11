package model;

import java.io.Serializable;

public class Billboard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private boolean use = false;

	private int w;

	private int h;

	private String brand;

	public Billboard(boolean use, int w, int h, String brand) {
		super();
		this.use = use;
		this.w = w;
		this.h = h;
		this.brand = brand;
	}

	/**
	 * @return the use
	 */
	public boolean isUse() {
		return use;
	}

	/**
	 * @param use the use to set
	 */
	public void setUse(boolean use) {
		this.use = use;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

}
