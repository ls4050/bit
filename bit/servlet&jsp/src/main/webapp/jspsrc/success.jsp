<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date now = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("hh시 mm분");
%>
<h1>"<%= ft.format(now) %>에 당첨~~~ 추카추카"</h1>
<img src="/edu/images/success.png">
</body>
<Style>
h1 {
	color : red
}
</Style>
</html>

