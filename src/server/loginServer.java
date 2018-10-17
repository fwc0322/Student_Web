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
		
		//��֤��
		//�û���д��֤��
		String randomCode=req.getParameter("randomCode");
		//��ȡsession�е���֤��
		String sessionRandCode=(String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");

		

		//���ù���Ա���û�����������;���û���дʱ����֤���Session�е���֤�����ȶ�
	    if(admin.equals("admin")&&pwd.equals("123")&&randomCode.equals(sessionRandCode)){
					Connection con =DbConnect.getConnecction();
					String sql="select * from student";
					PreparedStatement ps=null;
					ResultSet rs=null;

					try{
					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					HttpSession session=req.getSession();
					//����session��Чʱ����2Сʱ
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
