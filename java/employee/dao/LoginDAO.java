package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection con;
	
	public LoginDAO(Connection con) {
		this.con = con;
	}
	
	public boolean findEmployee(int empId,String password) throws SQLException {
		String sql = "select *from flm.login where employee_id = ?;";
		PreparedStatement stmt = null;
		ResultSet res = null;
		boolean result = false;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, empId);
			res = stmt.executeQuery();
			if(res.next()) {
				result = true;
			}
		} finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		
		return result;
	}
}
