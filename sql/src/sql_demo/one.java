package sql_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import sun.util.resources.cldr.es.TimeZoneNames_es_419;
public class one {
	public void fun1() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		Xlogin x=new Xlogin();
		ResultSet rs = stmt.executeQuery("select * from 用户信息 where 用户名 ='"+ x.t1.getText()+"'");
		System.out.println(x.t1.getText());
	
		
		//rs.next();
		String inf_username = rs.getString("密码");
		System.out.println(inf_username);
		if (inf_username.equals(x.t2.getText())){
			System.out.println("Successful");
		}
		
		
		
		/*while(rs.next()){
			int sno = rs.getInt(1);
			
			System.out.println(sno);
		}*/
		
	}
	
}