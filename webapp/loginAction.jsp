<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    ResultSet rs=(ResultSet) session.getAttribute("rs");
    %>
<html>
<head>

<title>学生管理系统</title>
<link rel="stylesheet" type="text/css" href="table.css"/>
</head>
<body>
	<center>
		<table class="gridtable">
			<tr>
			<td align="center" colspan="6">学生信息</td>
			</tr>
			<tr>
			    <td>姓名</td>
			    <td>性别</td>
				<td>专业</td>
				<td>年级</td>
				<td align="center" colspan="2">操作</td>
			</tr>
			<% 
				while(rs.next()){
				%>
			<tr>
				<td><%=rs.getString("name") %></td>
				<td><%=rs.getString("sex") %></td>
				<td><%=rs.getString("specialty") %></td>
				<td><%=rs.getString("grade") %></td>
				<td>
				<a href="selectServlet?id=<%=rs.getInt("id") %>">修改</a>
				</td>
				
				<td>				
				<a href="deleteServlet?id=<%=rs.getInt("id") %>" onClick
				="return confirm('确定要删除吗？');">删除</a>
				</td>			
			</tr>
			<%
			}
			%>
			<tr>
				<td align="center" colspan="6">
				<a href="stuAdd.jsp">添加</a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>