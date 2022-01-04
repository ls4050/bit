<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선택된 정보는 다음과 같습니다.</h1>
	<hr>
	<%
	ProductVO vo = (ProductVO) session.getAttribute("objProduct");
	%>
	선택된 사과의 개수 : <%= vo.getApple() %> <br>
	선택된 바나나의 개수 : <%= vo.getBanana() %> <br>
	선택된 할라봉의 개수 : <%= vo.getHalabong() %> 
	<hr>
	<a href="<%= request.getHeader("referer") %>">상품선택화면으로</a>
</body>
</html>