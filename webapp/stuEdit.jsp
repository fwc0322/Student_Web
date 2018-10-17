<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="bean.Student" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>

<title>添加学生信息</title>
<link rel="srylesheet" type="text/css" href="table.css">
</head>
<%
	Student stu=(Student)session.getAttribute("stu");
%>
<body>
	<form action="editServlet" method="post">
		<center>
			<table class="gridtable">
				<tr>
					<td align="center" colspan="2">添加学生信息
					<input type="hidden" name="id" value="<%=stu.getId()%>"/>
					</td>
				</tr>
				
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name" value="<%=stu.getName() %>"/></td>
				</tr>
				
				<tr>
					<td>性别</td>
					<%if(stu.getSex().equals("男")) { %>
					<td>
						<input type="radio" name="sex" value="男" checked="checked"/>男
						<input type="radio" name="sex" value="女"/>女
					</td>
					<%}else{ %>
					<td>
						<input type="radio" name="sex" value="男" />男
						<input type="radio" name="sex" value="女" checked="checked"/>女
					</td>
					<%} %>
				</tr>
				
				<tr>
					<td>专业</td>
					<td><input type="text" name="specialty" value="<%=stu.getSpecialty() %>"/></td>
				</tr>
				
				<tr>
					<td>年级</td>
					<td>
					<% if(stu.getGrade().equals("大一")){ %>
					<select name="grade">
						<option value="大一" selected="selected">大一</option> 
						<option value="大二">大二</option> 
						<option value="大三">大三</option> 
						<option value="大四">大四 </option> 
					</select>
					<%}else if(stu.getGrade().equals("大二")){ %>
					<select name="grade">
						<option value="大一" >大一</option> 
						<option value="大二" selected="selected">大二</option> 
						<option value="大三">大三</option> 
						<option value="大四">大四 </option> 
					</select>
					<% }else if(stu.getGrade().equals("大三")){ %>
					<select name="grade">
						<option value="大一" >大一</option> 
						<option value="大二">大二</option> 
						<option value="大三" selected="selected">大三</option> 
						<option value="大四">大四 </option> 
					</select>
					<% }else{ %>
					<select name="grade">
						<option value="大一" selected="selected">大一</option> 
						<option value="大二">大二</option> 
						<option value="大三">大三</option> 
						<option value="大四" selected="selected">大四 </option> 
					</select>
					<%} %>
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="修改"/>
					</td>
				</tr>
				
			</table>
		</center>
	</form>
</body>
</html>