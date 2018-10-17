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

public class deleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		
		String id=req.getParameter("id");
		String sql="delete from student where id=?";
		Connection con=DbConnect.getConnecction();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student stu=null;
		
		HttpSession session =req.getSession();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			int i=ps.executeUpdate();
			if(i==1){
				String sqll="select *from student";
				ps=con.prepareStatement(sqll);
				rs=ps.executeQuery();
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs",rs);	
				resp.sendRedirect("loginAction.jsp");
			}else{
				session.setAttribute("message", "É¾³ýÊ§°Ü");
				resp.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
	

}
