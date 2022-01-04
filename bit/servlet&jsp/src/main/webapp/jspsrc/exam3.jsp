<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>표현식 태그 점검</h1>
<hr>
<% int num = 10; %>
<%--<% int num = 10; 
선언하지 않은변수는 사용할 수 없다--%>
<ul>
	<li><%= 100%></li>
	<li><%= num %></li>
	<li><%= ++num%></li>
	<li><%= num*2%></li>
	<li><%= "가나다".length()%></li>
	<li><%= num%2==0%></li>
	<%-- 여기부터 내장객체 사용 예시 --%>
	<li><%= request.getParameter("stname")%></li>
	<%--
	jsp는 session객체 최초요청시에 자동생성된다
	브라우저 재기동 전까지 계속 살아있음 그러나 30분동안 요청없으면 자동삭제 = 서블릿이랑 같음
	--%>
	<li><%= new java.util.Date(session.getCreationTime())%></li>
	<li><%= application.getServerInfo()%></li>
	<li><%= application.getContextPath()%></li>
</ul>
</body>
</html>