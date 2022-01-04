<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str = request.getParameter("study");
if(str==null||str.equals("")) {
%>
	<h2>study 라는 이름으로 전달된 쿼리가 존재하지 않습니다.</h2>
<%
} else if(str.equals("javascript")) {
	response.sendRedirect("http://www.w3schools.com/js/default.asp");
} else if (str.equals("dom")) {
	response.sendRedirect("http://www.w3schools.com/js/js_htmldom.asp");
} else if (str.equals("ajax")) {
	response.sendRedirect("http://www.w3schools.com/xml/ajax_intro.asp");
} else if (str.equals("json")){
	response.sendRedirect("http://www.w3schools.com/js/js_json_intro.asp");
} else if (str.equals("jsp")) {
%>
	<jsp:forward page="exam6.jsp">
		<jsp:param name="dan" value="7"/>
	</jsp:forward> <!-- double side 스타일 -->
<%
} else if (str.equals("html")) {
%>
	<jsp:forward page="/htmlexam/first.html"/> <!-- single side 스타일 -->
<%
}
%>
</body>
</html>