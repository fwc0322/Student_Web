<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
th, tr, td, table {
	border: 1px solid red;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age<th>
		</tr>
 
		<c:forEach items="${key_list}" var="usr" varStatus="idx">
        <tr>
				<td>${usr.id}</td><td>${usr.name}</td> <td>${usr.age}</td> 
			</tr>
		</c:forEach>
 
 
 
 
	</table>
 
</body>
</html>
