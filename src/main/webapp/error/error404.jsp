<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%
  String contextPath = request.getContextPath();
%>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3; <%=contextPath %>/index.html">
<title>404에러</title>
<link rel="stylesheet" href="<%=contextPath %>/css/menu.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템</h1>
		</header>
		<section>
			<h1>오류가 발생했습니다.</h1>
			<h1>존재하지 않는 페이지입니다. 주소를 확인해 주세요.</h1>
		</section>
		<footer>환영합니다. </footer>
	</div>
</body>
</html>