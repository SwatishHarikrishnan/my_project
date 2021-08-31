package automateOfficeWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.checkerframework.common.reflection.qual.ForName;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdbc:oracle:thin:@192.168.151.34:1521:lycatest";
		String uname ="lycabluchertestnew3";
		String password="LYCA";
		String query="select * from TMO_IMSI_RANGE";
		Connection con = DriverManager.getConnection(url,uname,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
		String ACCOUNT_ID=rs.getInt(1) + " : " +rs.getString(2)+ " : " +rs.getString(3);
		System.out.println(ACCOUNT_ID);
		}
		rs.close();
		con.close();
	}

}
