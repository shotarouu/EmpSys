package employee.entity;

import java.io.Serializable;

public class Employee implements Serializable{
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private int empId;
	private String empName;
	private int departmentId;
	private String departmentName;
	private String phone;
	
	public Employee(){
		
	}
	
	public Employee(int empId, String empName, int departmentId, String phone) {
		this.empId = empId;
		this.empName = empName;
		this.departmentId = departmentId;
		this.phone = phone;
		
	}
	
	public Employee(int empId, String empName, int departmentId, String departmentName, String phone) {
		this.empId = empId;
		this.empName = empName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.phone = phone;
		
	}
	
}
