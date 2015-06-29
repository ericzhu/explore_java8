package jdbc.oracle.jdbc_oracle_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection conn = null;
		Statement stmt = null;
		String sql = "SELECT * FROM scenario";

		conn = DriverManager.getConnection("jdbc:oracle:thin:@kvh-ca-qmdbdev2:1521:altint11", "THUNDER_EZ_PLAY", "alt1");
		stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery(sql);
		while (results.next()) {
			int id = results.getInt("id");
			String name = results.getString("name");
			System.out.println(id + " - " + name);
		}

		stmt.close();
		conn.close();

	}
}
