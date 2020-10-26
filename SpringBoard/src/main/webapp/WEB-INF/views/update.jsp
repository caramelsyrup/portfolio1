<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기 화면</title>
</head>
<body>
<h2>수정하기 양식</h2>
	<form action="boardUpdate" method="post">
	  <div class="form-group">
	    <label for="NumForInsert">번호(Num)</label>
	    <input type="text" class="form-control" id="NumForInsert" name="num" value="${user.num}" readonly="readonly">
	  </div>
	  <div class="form-group">
	    <label for="TitleForInsert">제목(Title)</label>
	    <input type="text" class="form-control" id="TitleForInsert" name="title" value="${user.title}">
	  </div>
	  <div class="form-group">
	    <label for="ContentForInsert">내용(Content)</label>
	    <textarea class="form-control" id="ContentForInsert" rows="3" cols="20" name="content">${user.content}</textarea>
	  </div>
	  <div class="form-group">
	    <label for="WriterForInsert">작성자(Writer)</label>
	    <input type="text" class="form-control" id="WriterForInsert" name="writter" value="${user.writter}">
	  </div>
	  <div class="form-group">
	    <label for="PwdForInsert">비밀번호(Password)</label>
	    <input type="password" class="form-control" id="PwdForInsert" name="password" value="${user.password}">
	  </div>
	  <div class="form-group">
	    <label for="PwdForInsert">조회수(hitcount)</label>
	    <input type="number" class="form-control" id="PwdForInsert" name=hitcount value="${user.hitcount}" readonly="readonly">
	  </div>
	  <input type="submit" class="btn btn-success" value="작성"/>
	  <input type="button" class="btn btn-dark" onclick="history.back()" value="돌아가기">
	</form>
</body>
</html>