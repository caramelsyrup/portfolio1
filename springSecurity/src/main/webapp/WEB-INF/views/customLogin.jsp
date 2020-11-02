<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- action의 login과 name의 username, password는 미리 설정된 값 -->
<form action="/security/login" method="post">
	<div>
		<input type="text" name="username">
	</div>
	<div>
		<input type="password" name="password">
	</div>
	<div>
		<input type="submit">
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>