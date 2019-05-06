package com.music.musicweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierid;
	@NotNull
	private String suppliername;
	
	private int categoryid;
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	private int supplerstock;

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public int getSupplerstock() {
		return supplerstock;
	}

	public void setSupplerstock(int supplerstock) {
		this.supplerstock = supplerstock;
	}
	
}
