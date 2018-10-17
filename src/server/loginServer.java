package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.PreparedStatement;

import db.DbConnect;

public class loginServer extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		
		String admin=req.getParameter("admin");
		String pwd=  req.getParameter("pwd");
		
		//验证码
		//用户填写验证码
		String randomCode=req.getParameter("randomCode");
		//获取session中的验证码
		String sessionRandCode=(String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");

		

		//设置管理员的用户名和吗，密码;将用户填写时的验证码和Session中的验证码作比对
	    if(admin.equals("admin")&&pwd.equals("123")&&randomCode.equals(sessionRandCode)){
					Connection con =DbConnect.getConnecction();
					String sql="select * from student";
					PreparedStatement ps=null;
					ResultSet rs=null;

					try{
					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					HttpSession session=req.getSession();
					//设置session有效时间是2小时
					session.setMaxInactiveInterval(7200);
					session.setAttribute("rs",rs);	

					resp.sendRedirect("loginAction.jsp");

					}catch(SQLException e){
						e.printStackTrace();
					}
					
				}else{
				
				resp.sendRedirect("index.jsp");
				}
				
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 doGet(req, resp);
	}
	 
}
