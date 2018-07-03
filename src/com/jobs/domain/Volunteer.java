package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Volunteer(String name, String address, String phone, String description,double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);	
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
		//TODO
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);		
	}

}
