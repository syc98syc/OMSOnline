<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 - 정보 수정</title>
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
				<a href="javascript:history.back();" class="btn btn-secondary">뒤로가기</a>
			</div>
			<hr>

			<form
				action="${pageContext.request.servletContext.contextPath }/member/memberDetail.do"
				method="post">
				member_code: <input type="text" name="member_code"
					value="${member.member_code }" readonly><br>
				authority: <input type="text" name="authority"
					value="${member.authority }" readonly><br> name:<input
					type="text" name="name" value="${member.name }" readonly><br>
				id:<input type="text" name="id" value="${member.id }" readonly><br>
				pw:<input type="text" name="pw" value="${member.pw }"><br>
				contact:<input type="text" name="contact" value="${member.contact }"><br>
				join_date:<input type="text" name="join_date"
					value="${member.join_date } " readonly><br>
				<hr>
				<input type="submit" value="수정" class="btn btn-secondary">
			</form>
		</section>
		<%
		MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
		%>
		<footer><%=loginMem.getId()%>님, 환영합니다.
		</footer>
	</div>
</body>
</html>