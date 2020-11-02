<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	/sample/all page  
</h1>
<sec:authorize access="isAnonymous()"><a href="/security/customLogin">로그인</a></sec:authorize>
<sec:authorize access="isAuthenticated()"><a href="/security/customLogin">로그아웃</a></sec:authorize>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
