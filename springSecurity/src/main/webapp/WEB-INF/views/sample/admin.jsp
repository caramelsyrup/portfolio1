<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>admin접속자 페이지</h2>
	<p>principal : <sec:authentication property="principal"/></p>
	<p>사용자아이디 : <sec:authentication property="principal.username"/></p>
	<!-- get방식으로 링크만 연결. 실질적 로그아웃은 post방식으로 되면 스프링에서 알아서 처리 -->
	<a href="/security/customLogout">Logout</a>
</body>
</html>