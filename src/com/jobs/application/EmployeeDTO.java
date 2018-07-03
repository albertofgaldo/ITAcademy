package com.jobs.application;

import com.jobs.domain.AbsStaffMember;

public class EmployeeDTO {
	
	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;
	
	//public EmployeeDTO() {}
	
	public EmployeeDTO(AbsStaffMember e) {
		this.id=e.getId();
		this.name=e.getName();
		this.address=e.getAddress();
		this.phone=e.getPhone();
		this.totalPaid=e.getTotalPaid();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
	
	public double getTotalPaid() {
		return totalPaid;
	}

}
