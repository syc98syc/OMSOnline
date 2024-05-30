<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>회원가입</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/menu.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script>
	$(function() {
		$("#btnDupCheck").on("click", f_dupCheck);
	});
	function f_dupCheck() {
		var uid = $("#uid").val();
		if (uid == "") {
			alert("ID를 입력하세요");
			document.querySelector("#uid").focus();
			return;
		}
		$.ajax({
			url : "userIdCheck.do",
			data : {
				"uid" : uid
			},
			type : "get",
			success : function(responseData) {
				var message = "";
				//console.log(responseData);
				if (responseData == "0") {
					message = "사용가능";
				} else {
					message = "사용불가";
					$("uid").val("");
					document.querySelector("#uid").focus();
				}
				$("#resultMessage").val(message);
			},
			error : function(data) {
				alert(data);
			}
		});
	}
</script>
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템</h1>
		</header>
		<section>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a href="javascript:history.back();" class="btn btn-secondary">뒤로가기</a>
			</div>
			<hr>

			<div class="container mt-3">
				<h2>신규회원가입</h2>
				<form action="join.do" method="post">
					<div class="mb-3 mt-3">
						<label for="uid">ID:</label> <input type="text"
							class="form-control" id="uid" placeholder="Enter ID" name="uid"
							required="required"> <input type="button" value="중복체크"
							id="btnDupCheck" class="btn btn-secondary btn-sm"> <input
							type="text" value="ID입력후 중복체크" id="resultMessage">
					</div>
					<div class="mb-3 mt-3">
						<label for="pw">PW:</label> <input type="password"
							class="form-control" id="pw" placeholder="Enter PW" name="pw"
							required>
					</div>
					<div class="mb-3 mt-3">
						<label for="name">이름:</label> <input type="text"
							class="form-control" id="name" placeholder="Enter name"
							name="name" required>
					</div>
					<div class="mb-3 mt-3">
						<label for="contact">연락처:</label> <input type="text"
							class="form-control" id="contact" placeholder="Enter contact"
							name="contact" required>
					</div>

					<button type="submit" class="btn btn-primary">가입하기</button>
				</form>
			</div>
		</section>
		<footer>환영합니다. </footer>
	</div>
</body>
</html>