package employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.dao.ConnectionManager;
import employee.dao.EmployeeDAO;
import employee.entity.Employee;

public class EmployeeUpdateLogic {
	public boolean updateEmployee(Employee employee)
			throws EmployeeBusinessException, EmployeeSystemException, ClassNotFoundException {

		Connection con = null;
		boolean result = false;

		try {
			con = ConnectionManager.getConnection();

			//自動コミットモードの解除
			con.setAutoCommit(false);

			EmployeeDAO employeeDAO = new EmployeeDAO(con);

			result = employeeDAO.updateEmployee(employee);

			if (result == false) {
				throw new EmployeeSystemException("更新処理に失敗しました。");
			}

			//コミット処理
			con.commit();

		} catch (SQLException e) {

			try {
				// トランザクションのロールバック
				con.rollback();
			} catch (SQLException e2) {
				// スタックトレースを出力
				e2.printStackTrace();
			}
			throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
		} finally {
			try {
				if (con != null) {
					//オートコミット有効化
					con.setAutoCommit(true);
					con.close();
				}
			} catch (SQLException e) {
				throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
			}
		}

		return result;

	}
}
