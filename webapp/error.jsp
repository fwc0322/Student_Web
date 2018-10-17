<%@ page languag="java" impost="java.util.*" pageEncoding="utf-8"%>
<% 
	String message=(String)session.getAttribute("message");
    out.print(message);
%>