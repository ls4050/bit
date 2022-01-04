<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="jspbean.Today"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Poor+Story:400" rel="stylesheet">
</head>
<body>
<h1 style="font-family: 'Poor Story';">지금은
<%-- 어떤객체 안에다 보관하느냐, getAttribute, removeAttribte --%>
<%
pageContext.setAttribute("obj", new Today());
%>
<%-- $쓰고 중괄호, EL은 getter만 호출가능 setter는 안된다 --%>
<%-- EL에서의 변수는 어떤 스코프에 존재하는 객체를 꺼내기위한 이름이다 --%>
<%-- today객체를 세션, request, servlets context, pagecontext에 보관할 수 있다 --%>
${obj.year}년 <%-- obj로 보관돼있는 객체를 찾아서 거기있는 getYear를 호출해라 --%>
${obj.month}월 
${obj.date}일
${obj.hour}시 
${obj.minute}분 입니당</h1>
</body>
</html>