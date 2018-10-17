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

public class addServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String sex=  req.getParameter("sex");		
		String specialty=req.getParameter("specialty");
		String grade=  req.getParameter("grade");
		
		Student stu=new Student(name,sex,specialty,grade);
		Connection con=DbConnect.getConnecction();
		
		String sql="insert into student(name,sex,specialty,grade) values(?,?,?,?)";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,stu.getName());
			ps.setString(2,stu.getSex());
			ps.setString(3,stu.getSpecialty());
			ps.setString(4,stu.getGrade());
			
			int i=ps.executeUpdate();				
			HttpSession session =req.getSession();
			if(i==1){
				String sqll="select *from student";
				ps=con.prepareStatement(sqll);
				rs=ps.executeQuery();
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs",rs);	
				resp.sendRedirect("loginAction.jsp");
			}else{
				session.setAttribute("message", "ÃÌº” ß∞‹");
				resp.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doGet(req, resp);
}
 
}
