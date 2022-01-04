<!-- 지시자 language는 생략하더라도 contentType은 생략하면 안된다 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제1</title>
</head>
<body>
<h1>JSP 맛보기</h1>
<hr>
<!-- 
%뒤에 = 나 @ 무조건 붙어있어야함 공백X 
표현식 뒤에 자바코드
;(세미콜론) 쓰면 안된다
-->
<h3>현재 시간 정보 : <%= java.time.LocalDateTime.now() %></h3>
</body>
</html>