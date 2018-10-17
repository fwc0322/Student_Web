<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>学生管理系统</title>
</head>
<body>

 <center>
 	管理员登录界面
 	<form action="loginServer" method="post">
 	
 		<table>
 		  <tr>
 			<td>用户名：</td>
 			<td><input type="text" name="admin"/></td>
 		  </tr>
 		  <tr>
 			<td>密码：</td>
 			<td><input type="text" name="pwd"/></td>
 		  </tr>	
 		  <tr>
 			<td>验证码:</td>
 			<td><input type="text" name="randomCode" maxlength="5" style="width:88px "/>
 		  <img alt="验证码" src="randomCode" title="看不清？点击切换"><br></td>
 		  </tr>			 	 	  		
 		  <tr>
 		  	<td colspan="2" align="center">
 		  	<input type="submit" value="登录"/>
 		  	</td>
 		  </tr>
 		 
 		</table>
 		
 	</form>
 </center>

</body>
</html>