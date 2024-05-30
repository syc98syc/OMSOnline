<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3; ../main/managerMain.jsp">
<title>처리중입니다..</title>
<link rel="stylesheet" href="../css/menu.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템</h1>
		</header>
		<section>
			<h1>${message }</h1>
		</section>
		<%
		MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
		%>
		<footer><%=loginMem.getId()%>님, 환영합니다.
		</footer>
	</div>
</body>
</html>