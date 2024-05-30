<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/menu.css">
<title>관리자 - 메뉴</title>
<style>
#size{
 font-size: 25px;
}
</style>
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템 - 관리자</h1>
		</header>
		<section>
			<nav>
				<a href="../menu/selectAll.go">메뉴관리</a>
				<a href="../order/selectAll.go">주문관리</a>
				<a href="../auth/logout.do">로그아웃</a>
				
			</nav>
		</section>
		<%
		 MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
		%>
		<footer><%=loginMem.getId() %>님, 환영합니다.</footer>
	</div>
</body>
</html>