<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1>
	<hr>
	<ul>
		<li>회원 이름 :${objMember.name}</li>
		<li>회원 계정 : ${objMember.id}</li>
		<li>회원 암호 : ${objMember.pwd}</li>
		<li>회원 전화번호 : ${objMember.phone}</li>
	</ul>
</body>
</html>