<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
	<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
	<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
	<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>
<div class="container" align="center">
  <div class="row align-items-start">
    <div class="col">
      <h1 class="h1">Home</h1>
      <h2 class="h2">${serverTime}</h2>
      <h3 class="h3">
      	<sec:authorize access="isAnonymous()">
      		<a href="/security/customLogin">로그인</a>
      		<a href="/security/board/boardInsert">글쓰기</a>
      	</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="/security/customLogin">로그아웃</a>
		</sec:authorize>
      </h3>
    </div>
  </div>
</div>



</body>
</html>
