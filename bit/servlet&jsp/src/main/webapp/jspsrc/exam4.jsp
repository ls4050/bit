<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Query 문자열추출(GET&amp;POST)</h1>
<hr>
<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("utf-8");
	}
%>
<h2>당신의 이름은 <%= request.getParameter("name") %> 이군요!!</h2>
<%-- 이 jsp가 요청되기까지 html을 통해서 요청된거니까 이 html에 대한 정보를 추출 --%>
<a href="<%=request.getHeader("referer")%>">입력화면으로</a>
</body>
</html>