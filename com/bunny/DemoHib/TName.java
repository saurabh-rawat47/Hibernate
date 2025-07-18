package com.bunny.DemoHib;

import jakarta.persistence.Embeddable;

@Embeddable
public class TName {
	private String fname;
	private String mname;
	private String lname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	@Override
	public String toString() {
		return "TName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
