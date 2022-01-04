<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Calendar  cal= Calendar.getInstance();
SimpleDateFormat ft = new SimpleDateFormat("hh시 mm분");
cal.add(Calendar.MINUTE, 30);
String today = ft.format(cal.getTime());
%>
<h1>"더 이상 응모할 수 없어요... <%= today %>이후에 응모하거나 브라우저를 재기동한 후에는 가능하답니다.</h1>
</body>
<Style>
h1 {
color : red;
}
</Style>
</html>

