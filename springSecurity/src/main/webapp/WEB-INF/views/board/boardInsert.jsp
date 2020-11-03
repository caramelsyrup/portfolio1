<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>BoardInsert</title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
	<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
	<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
	<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>
	<form action="/security/board/insert" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	  <div class="form-group">
	    <label for="TitleForInsert">제목(Title)</label>
	    <input type="text" class="form-control" id="TitleForInsert" name="title" placeholder="within 20 characters Title">
	  </div>
	  <div class="form-group">
	    <label for="ContentForInsert">내용(Content)</label>
	    <textarea class="form-control" id="ContentForInsert" rows="3" cols="20" name="content"></textarea>
	  </div>
	  <div class="form-group">
	    <label for="WriterForInsert">작성자(Writer)</label>
	    <input type="text" class="form-control" id="WriterForInsert" name="writter" value='<sec:authentication property="principal.username"/>'readonly="readonly" ">
	  </div>
	  <div class="form-group">
	    <label for="PwdForInsert">비밀번호(Password)</label>
	    <input type="text" class="form-control" id="PwdForInsert" name="password" placeholder="within 8 characters Password">
	  </div>
	  <input type="submit" class="btn btn-success" value="작성"/>
	  <input type="reset" class="btn btn-dark" value="취소"/>
	</form>
	<div id="listView">
	<h2></h2>
	<table class="table table-striped">
		<thead class="thead-dark"></thead>
		<tbody></tbody>
	</table>
</div>
</body>
</html>