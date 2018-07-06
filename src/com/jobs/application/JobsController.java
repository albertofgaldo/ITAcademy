package com.jobs.application;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository= new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public EmployeeDTO createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);	
		return new EmployeeDTO(manager);
	}
	
	public EmployeeDTO createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{			
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
		return new EmployeeDTO(boss);
	}
	
	public EmployeeDTO createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
		return new EmployeeDTO(boss);
	}

	public EmployeeDTO createVolunteer(String name, String address, String phone) throws Exception{	
		Employee volunteer = new Employee(name, address, phone,  0, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(volunteer);
		return new EmployeeDTO(volunteer);
		
	}

	public void payAllEmployeers() {
		for (AbsStaffMember member: repository.getAllMembers()) {
			member.pay();
		}			
	}

	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub	
		List <EmployeeDTO> e=new ArrayList<EmployeeDTO>();
		//recorro repository para guardar cada elemento en la lista e employee. Devuelvo la lista
		for (AbsStaffMember member : repository.getAllMembers()) {
			e.add(new EmployeeDTO(member));
		}
		return e;
	}

	AbsStaffMember searchMember(String name) throws Exception{
		AbsStaffMember e=null;
		for (AbsStaffMember member : repository.getAllMembers()) {
			if(member.getName().equalsIgnoreCase(name)) {
				e= member;
			}			
		}
		return e;
	}
	
	public void deleteMember(String name) throws Exception{
		AbsStaffMember member = this.searchMember(name);
		if(member!= null) {
			repository.delMember(member);
			System.out.println("Borrado");
		}else {
			System.out.println("Empleado no encontrado");
		}
				
	}
	
	
}
