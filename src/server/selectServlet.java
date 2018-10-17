package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import db.DbConnect;

public class selectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		
		String id=req.getParameter("id");

		String sql="select * from student where id=?";
		Connection con=DbConnect.getConnecction();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student stu=null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
		
			
			rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				String sex=  rs.getString("sex");		
				String specialty=rs.getString("specialty");
				String grade=  rs.getString("grade");
				stu=new Student(name, sex, specialty, grade, Integer.parseInt(id));
				
			}
	
			HttpSession session=req.getSession();
			session.setAttribute("stu", stu);
			resp.sendRedirect("stuEdit.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}
