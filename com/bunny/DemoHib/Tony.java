package com.bunny.DemoHib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_table")
public class Tony {
	@Id
	private int id;
	private TName name;

	private String fcolor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public TName getName() {
		return name;
	}

	public void setName(TName name) {
		this.name = name;
	}

	public String getFcolor() {
		return fcolor;
	}

	public void setFcolor(String fcolor) {
		this.fcolor = fcolor;
	}

	@Override
	public String toString() {
		return "Tony [id=" + id + ", name=" + name + ", fcolor=" + fcolor + "]";
	}
}
