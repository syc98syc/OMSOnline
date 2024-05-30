<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 - 주문하기</title>
<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템 - 사용자</h1>
		</header>
		<section>

			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a href="javascript:history.back();"
					class="btn btn-secondary me-md-2">뒤로가기</a>
			</div>
			<hr>

			<%
			MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
			%>
			<form
				action="${pageContext.request.servletContext.contextPath}/myorder/orderInsert.do"
				method="post">
				
				메뉴: <select name="menu_code">
				  <c:forEach var="menu" items="${mlist }">
					<option value="${menu.menu_code}">${menu.name }</option>
					</c:forEach>
				</select>
				<br>
				<%-- 메뉴코드 : <input type="text" name="menu_code" list="menulist"><br>
				<datalist id="menulist">
					<c:forEach var="menu" items="${mlist }">
					<option value="${menu.menu_code}">${menu.name }</option>
					</c:forEach>
				</datalist> --%>
				멤버코드 : <input type="text" name="member_code"
					value="<%=loginMem.getMember_code()%>" readonly><br>
				수량 : <input type="number" name="quantity" min="1"> <br>
				<hr>
				<input type="submit" value="입력" class="btn btn-secondary">
			</form>
		</section>
		<footer><%=loginMem.getId()%>님, 환영합니다.
		</footer>
	</div>
</body>
</html>