package db;

import java.sql.Connection;
import java.sql.DriverManager;

//�������ݿ�
public class DbConnect {
	public static Connection con;
	public static String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
	public static String jdbcUser = "root";//���ݿ��û���
	public static String jdbcPwd = "770295meinu";//���ݿ�����
	public static Connection getConnecction(){
		
		//1.��Ŀ�м���jar������JDBC���ݿ���������
		try {
			//2.�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//3.���ݿ����ӵ�ַ�����ݿ����������ݿ��˻����������ʽ
			
			//���������ݿ������
			con=DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPwd);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return con;
		
	}
	
	
	
}
