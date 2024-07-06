package employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.dao.ConnectionManager;
import employee.dao.EmployeeDAO;
import employee.dao.LoginDAO;
import employee.entity.Employee;

public class LoginLogic {
	public Employee login(int empId, String password) throws EmployeeBusinessException,EmployeeSystemException, ClassNotFoundException{
		Connection con = null;
		Employee employee = null;
		
		try {
			 con = ConnectionManager.getConnection();
			 LoginDAO loginDAO = new LoginDAO(con);
			 boolean result = loginDAO.findEmployee(empId,password);
			 
			 if(result == false) {
				 throw new EmployeeSystemException("ログインに失敗しました");
			 }
			 
			 EmployeeDAO employeeDAO = new EmployeeDAO(con);
			 
			 employee = employeeDAO.findEmployeeById(empId);
			 
			 if(employee == null) {
				 throw new EmployeeSystemException("ログインに失敗しました");
			 }
			 
		} catch (SQLException e) {
			throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
			}
		}
		
		return employee;
	}
}
