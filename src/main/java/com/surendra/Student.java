package com.surendra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	private String sName;
	private Integer sClass;
	private double sFee;
	
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsClass() {
		return sClass;
	}
	public void setsClass(Integer sClass) {
		this.sClass = sClass;
	}
	public double getsFee() {
		return sFee;
	}
	public void setsFee(double sFee) {
		this.sFee = sFee;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sClass=" + sClass + ", sFee=" + sFee + "]";
	}
	
	

}
