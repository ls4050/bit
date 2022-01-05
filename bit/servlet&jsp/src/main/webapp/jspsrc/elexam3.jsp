<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL 변수</h2>
<hr>
<%-- name이라는 이름으로 보관된 내장객체이거나 어딘가에 보관되어있는 객체의 이름 --%>
<%-- name은 내장객체가 아니므로 '객체의 이름'으로 찾음, 그러나 없으므로 빈칸으로 출력 --%>
name 변수의 값 : ${name}<br>
<% String name="듀크"; %>
name 변수의 값(표현식 태그) : <%= name %><br>
name 변수의 값(EL) : ${name}<br>
<%-- jsp 수행 끝날때 사라짐 = pageContext --%>
<% pageContext.setAttribute("name", "자바");  %>
<%-- 
pageScope영역의 name이라는 객체를 찾아서 호출
scope생략가능하나, 생략시에는 모든 scope영역을 다찾아보고 가져오는 것임
scope를 명시해주는 것이 가독성 좋다 
--%>
name 변수의 값 : ${name}<br>
pageScope.name 변수의 값 : ${pageScope.name}<br>
<hr>
<% pageContext.setAttribute("number", 100); %>
number 변수의 값 : ${number}<br>
pageScope.number 변수의 값 : ${pageScope.number}<br>
number 변수의 값에 23을 더한 값 : ${ number + 23 }
</body>
</html>

