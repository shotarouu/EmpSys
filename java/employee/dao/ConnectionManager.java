package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	//データベース接続情報
	private static final String URL = "jdbc:mysql://localhost:3306/MySQL?allowPublicKeyRetrieval=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "パスワードを入れてください";
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return con;
	}
}
