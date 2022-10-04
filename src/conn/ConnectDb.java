package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/manager?useUnicode=true&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "";
	
	public Connection getConnectMySql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		ConnectDb db = new ConnectDb();
		System.out.println(db.getConnectMySql());
	}
}
