package employee.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.dao.ConnectionManager;
import employee.dao.EmployeeDAO;
import employee.entity.Employee;

public class EmployeeFindAllLogic {
	public ArrayList<Employee> findAllEmployee()
			throws EmployeeSystemException, ClassNotFoundException, EmployeeBusinessException {
		Connection con = null;
		ArrayList<Employee> empList = new ArrayList<>();

		try {
			con = ConnectionManager.getConnection();

			EmployeeDAO employeeDAO = new EmployeeDAO(con);

			empList = employeeDAO.findAllEmployee();

			if (empList.size() == 0) {
				throw new EmployeeBusinessException("従業員は存在しません。");
			}
		} catch (SQLException e) {
			throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
			}
		}

		return empList;
	}
}
