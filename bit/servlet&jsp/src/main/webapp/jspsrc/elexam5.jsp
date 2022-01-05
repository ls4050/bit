<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>저장된 객체 추출	</h2>
<hr>
<%
pageContext.setAttribute("msg", "PageContext 객체에 저장된 객체");
request.setAttribute("msg", "HttpservletRequest 객체에 저장된 객체");
//session.setAttribute("msg", "HttpSession 객체에 저장된 객체");
application.setAttribute("msg", "ServletContext 객체에 저장된 객체");
%>
pageScope 객체에서 추출 : ${pageScope.msg }<br>
requestScope 객체에서 추출 : ${requestScope.msg}<br>
sessionScope 객체에서 추출 : ${sessionScope.msg }<br>
application 객체에서 추출 : ${applicationScope.msg }<br>
${msg}
</body>
</html>