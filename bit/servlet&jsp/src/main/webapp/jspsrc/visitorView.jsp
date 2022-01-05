<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.VisitorVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<VisitorVO> list = (ArrayList<VisitorVO>)request.getAttribute("list");
	if (list != null) {
	%>
	<h2>방명록 글 리스트</h2>
	<table>
		<%
		for (VisitorVO vo : list) {
		%>
		<tr>
			<td><%=vo.getName()%></td>
			<td><%=vo.getWriteDate()%></td>
			<td><%=vo.getMemo()%></td>
			<td><a href='/edu/visitordb2?id=<%=vo.getId()%>&action=delete'>
					<img src="/edu/images/delete.png" width="30">
			</a></td>
			<td><a href='/edu/visitordb2?id=<%=vo.getId()%>&action=update'>
					<img src="/edu/images/edit.png" width="30">
			</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<h2>${msg}</h2>
	<%
	}
	%>
	<hr>
	<a href="/edu/htmlexam/visitorMain.html">방명록 홈 화면으로 가기</a>
</body>
<style>
td {
	border-bottom: 1px dotted green;
}

tr:hover {
	background-color: pink;
	font-weight: bold;
}
<%-- 강제로 400px로 잡았기 때문에 글 쓰는 방명록 길이가 길다. --%>
td:nth-child(3) {
	width: 400px;
}
</style>
</html>