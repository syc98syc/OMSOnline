<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<%
  String contextPath = request.getContextPath();
%>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3; <%=contextPath %>/index.html">
<title>500에러</title>
<link rel="stylesheet" href="<%=contextPath %>/css/menu.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템</h1>
		</header>
		<section>
			<h1>오류가 발생했습니다.</h1>
			<h2><%=exception%></h2>
			<h2>
				원인:
				<%=exception.getMessage()%></h2>
		</section>
		<footer>환영합니다. </footer>
	</div>
</body>
</html>