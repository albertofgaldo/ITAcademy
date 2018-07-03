package com.jobs.view;

import java.util.List;
import java.util.Scanner;

import com.jobs.application.EmployeeDTO;
import com.jobs.application.JobsController;
import com.jobs.domain.Employee;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		EmployeeDTO boss= controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		EmployeeDTO employee1=controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		EmployeeDTO employee2=controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		EmployeeDTO volunteer=controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		EmployeeDTO manager=controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);
		
		
		int opc=0;
		String name=null;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("[1] Ver empleados");
			System.out.println("[2] Pagar a todos los empleados");
			System.out.println("[3] Borrar un empleado");
			System.out.println("[0] Salir");
			opc=Integer.parseInt(sc.nextLine());
		
			switch (opc) {
			case 1:				
				//recojo la lista para recorrerla y mostrar los valores
				List<EmployeeDTO> allEmployees=controller.getAllEmployees();
				StringBuilder sb = new StringBuilder();
				
				//System.out.println("EMPLOYEES: " + allEmployees + " \n");
				for (EmployeeDTO employee : allEmployees) {
					sb.append("\n");
					sb.append("\nNombre: ");
					sb.append(employee.getName());
					sb.append("\nDirección: ");
					sb.append(employee.getAddress());
					sb.append("\nPagado: ");
					sb.append(employee.getTotalPaid());	
					sb.append("\n---------------------");	
				}
				System.out.println("EMPLOYEES:");
				System.out.println(sb);
				
				break;
			case 2:
				controller.payAllEmployeers();
				break;
			case 3:
				System.out.println("Inserta el nombre del empleado a borrar: ");
				name=sc.nextLine();
				controller.deleteMember(name);
				break;
			default:
			opc=0;
				break;
			}
		}while (opc!=0);
		
		sc.close();
	}
	
}
