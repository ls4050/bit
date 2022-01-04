<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   errorPage="errorPage.jsp"  %> <!-- 트라이캐치 몰라도 에러 컨트롤 가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>errorPage 속성 테스트</h2>
<hr>
<%
     String name = request.getParameter("guestName"); 
%>
<h3>당신의 이름은 <%= name %> 이고 이름의 길이는
           <%= name.length() %> 입니다.</h3> <!-- 에러발생지점 null을 가지고 string.lenth를 호출하려해서 -->
</body>
</html>















