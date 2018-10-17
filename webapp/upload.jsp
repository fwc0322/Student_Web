<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="FileUpload" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>文件</td>
				<td><input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="上传" ></td>
			</tr>
		</table>		
	</form>
</body>
</html>