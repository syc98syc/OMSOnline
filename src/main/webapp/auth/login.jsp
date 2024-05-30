<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/menu.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
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
				<h2>로그인</h2>
				<form action="login.do" method="post">
					<div class="mb-3 mt-3">
						<label for="email">ID:</label> <input type="text"
							class="form-control" id="uid" name="id">
					</div>
					<div class="mb-3">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" id="pwd" name="pw">
					</div>
					<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
		</section>
		<footer>환영합니다. </footer>
	</div>
</body>
</html>