<!-- 
JSP는 doPost doGet을 나누지 않는다
service()메서드안으로 들어가서 수행하기때문에 
get이나 post중 하나를 쓰겠다하면 직접구현해서 써야한다
-->
<!-- 지시자태그 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 선언문태그 = 멤버변수선언, 세미콜론 무조건 줘야함 -->
<%! int member_v=0; %>
<!-- 수행문태그 = 지역변수선언, 세미콜론 무조건 줘야함, 거의다 수행문태그에서 수행 출력할때만 표현식 사용 -->
<%
  int local_v=0;
  member_v+=10;
  local_v+=10;
%>
<!-- out.write의 아규먼트로 들어가서 화면에 바로 보이는 것 -->
<h1>JSP의 멤버변수와 지역변수</h1>
<hr>
<ul>
	<!-- 표현식태그, 세미콜론 안줘야함, 식만 올수있다(out.print()안에 들어가는놈만 온다) -->
	<li>멤버 변수 : <%= member_v %> </li>
	<li>지역 변수 : <%= local_v %> </li>
</ul>
</body>
</html>