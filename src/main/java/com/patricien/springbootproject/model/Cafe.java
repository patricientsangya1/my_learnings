package com.patricien.springbootproject.model;

import javax.persistence.*;
//import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cafe")
public class Cafe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemCode;
	private String itemName;
	private String category;
	private int price;
	
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
}
