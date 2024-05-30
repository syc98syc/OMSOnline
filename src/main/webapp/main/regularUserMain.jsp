<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/menu.css">
<title>사용자 - 메뉴</title>
<style>
#size {
	font-size: 25px;
}
</style>
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템 - 사용자</h1>
		</header>
		<%
		MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
		%>
		<section>
			<nav>
				<a href="../menu/viewAll.do">메뉴조회</a> <a
					href="../myorder/orderInsert.do">주문하기</a> <a
					href="../myorder/selectAll.do?member_code=<%=loginMem.getMember_code()%>">내역조회</a>
				<a
					href="../member/memberDetail.do?member_code=<%=loginMem.getMember_code()%>">정보수정</a>
				<a
					href="../member/memberDelete.do?member_code=<%=loginMem.getMember_code()%>"
					onclick="return confirm('회원 탈퇴시 복구 불가능합니다.');삭제">회원탈퇴</a> <a href="../auth/logout.do">로그아웃</a>

			</nav>
		</section>
		<footer><%=loginMem.getId()%>님, 환영합니다.
		</footer>
	</div>
</body>
</html>