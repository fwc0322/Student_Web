package db;

import java.sql.Connection;
import java.sql.DriverManager;

//连接数据库
public class DbConnect {
	public static Connection con;
	public static String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
	public static String jdbcUser = "root";//数据库用户名
	public static String jdbcPwd = "770295meinu";//数据库密码
	public static Connection getConnecction(){
		
		//1.项目中加入jar包，及JDBC数据库连接驱动
		try {
			//2.加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//3.数据库连接地址，数据库名：，数据库账户名，编码格式
			
			//创建与数据库的连接
			con=DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPwd);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return con;
		
	}
	
	
	
}
