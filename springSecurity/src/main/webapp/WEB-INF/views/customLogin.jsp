<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
	<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
	<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
	<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>

<!-- action의 login과 name의 username, password는 미리 설정된 값. 그리고 반드시 post를 설정해야한다. -->
	<div align="center">
		<form action="/security/login" method="post">
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text">아이디</span>
		  </div>
		  <input type="text" name="username" class="form-control" aria-label="Amount (to the nearest dollar)">
		</div>
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text">비밀번호</span>
		  </div>
		  <input type="password" name="password" class="form-control" aria-label="Amount (to the nearest dollar)">
		</div>
		<div>
			<input type="checkbox" name="remember-me" >Remember Me
		</div>
		<div>
			<input type="submit" class="btn btn-primary" >
		</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
	</div>
</body>
</html>