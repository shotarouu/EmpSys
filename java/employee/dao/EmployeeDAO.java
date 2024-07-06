package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import employee.entity.Employee;

public class EmployeeDAO {
	private Connection con;

	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	public Employee findEmployeeById(int empId) throws SQLException {
		String sql = "select employee_id,enmployee_name,department_id,phone from flm.employee where employee_id = ?;";

		PreparedStatement stmt = null;
		ResultSet res = null;
		Employee employee = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, empId);
			res = stmt.executeQuery();
			if (res.next()) {
				System.out.println(res.getInt("employee_id"));
				employee = new Employee(res.getInt("employee_id"), res.getString("enmployee_name"),
						res.getInt("department_id"), res.getString("phone"));
			}
		} finally {
			if (res != null) {
				res.close();
			}

			if (stmt != null) {
				stmt.close();
			}
		}
		return employee;
	}

	//一覧表示
	public ArrayList<Employee> findAllEmployee() throws SQLException {
		String sql = "select *from flm.employee;";

		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Employee> empList = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);
			res = stmt.executeQuery();
			Employee employee = null;
			while (res.next()) {
				System.out.println(res.getInt("employee_id"));
				employee = new Employee(res.getInt("employee_id"), res.getString("enmployee_name"),
						res.getInt("department_id"), res.getString("phone"));
				empList.add(employee);
			}
		} finally {
			if (res != null) {
				res.close();
			}

			if (stmt != null) {
				stmt.close();
			}
		}
		return empList;
	}

	//削除処理
	public boolean deleteEmployee(Employee employee) throws SQLException {
		String sql = "delete from flm.employee where employee_id = ?;";

		PreparedStatement stmt = null;
		boolean result = false;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, employee.getEmpId());
			int rows = stmt.executeUpdate();
			if (rows == 1) {
				result = true;
			}
		} finally {

			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
	
	
	//登録処理
	public boolean registEmployee(Employee employee) throws SQLException{
		String sql = "insert into flm.employee values(?,?,?,?);";
		
		PreparedStatement stmt = null;
		boolean result = false;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, employee.getEmpId());
			stmt.setString(2, employee.getEmpName());
			stmt.setInt(3, employee.getDepartmentId());
			stmt.setString(4, employee.getPhone());
			int rows = stmt.executeUpdate();
			if (rows == 1) {
				result = true;
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
	
	
	//更新処理
		public boolean updateEmployee(Employee employee) throws SQLException{
			String sql = "update flm.employee set employee_id=?,enmployee_name=?,department_id=?,phone=? where employee_id=?";
			
			PreparedStatement stmt = null;
			boolean result = false;
			
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, employee.getEmpId());
				stmt.setString(2, employee.getEmpName());
				stmt.setInt(3, employee.getDepartmentId());
				stmt.setString(4, employee.getPhone());
				stmt.setInt(5, employee.getEmpId());
				int rows = stmt.executeUpdate();
				if (rows == 1) {
					result = true;
				}
			} finally {
				if (stmt != null) {
					stmt.close();
				}
			}
			return result;
		}
}
