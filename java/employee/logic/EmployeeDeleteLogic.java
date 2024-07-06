package employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.dao.ConnectionManager;
import employee.dao.EmployeeDAO;
import employee.entity.Employee;

public class EmployeeDeleteLogic {
public Employee deleteEmployeeById(Employee employee) throws EmployeeBusinessException,EmployeeSystemException, ClassNotFoundException{
		
		Connection con = null;
		
		try {
			con = ConnectionManager.getConnection();
			
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			
			boolean result = employeeDAO.deleteEmployee(employee);
			
			if(!result) {
				throw new EmployeeBusinessException("削除に失敗しました。");
			}
		} catch (SQLException e) {
			throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
			}
		}
		
		return employee;
		
	}
}
