package com.bunny.DemoHib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Laptop2 {

	@Id
	private int id;
	private String brand;
	private int price;

	public int getLid() {
		return id;
	}

	public void setLid(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop2 [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}

}
