<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript" src="<c:url value="/resources/memberScript.js"/>"></script>
<script src="/board/resources/boardScript.js"></script>
<body>
	<h1 class="h1">로그인화면</h1>
	<h1 class="h1">${serverTime}</h1>
<form action="login" method="post" id="loginForm">
	<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="basicID">아이디</span>
		  </div>	
		  <input type="text" class="form-control" id="LID" name="LID" placeholder="8자 이내" aria-label="Example text with button addon" aria-describedby="button-addon1">
	</div>
	<div class="input-group mb-3">	  
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="basicPASS">비밀번호</span>
		  </div>
		  <input type="text" class="form-control" id="LPASS" name="LPASS" placeholder="10자 이내" aria-label="Example text with button addon" aria-describedby="button-addon1">
	</div>	 
	 <div class="container">
		 <div class="row">
		  <div class="col-1"> <input class="btn btn-primary" type="button" id="btnLogin" value="로그인"></div>
		  <div class="col-1"> <input class="btn btn-secondary" type="reset" value="취소"></div>
		  <div class="col-1"> <input class="btn btn-secondary" type="button" id="btngoJoin" value="회원가입"></div>
		 </div>
	</div>
</form>
</body>
</html>