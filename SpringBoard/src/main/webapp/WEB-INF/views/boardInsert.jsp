<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
	<form action="boardInsert" method="post">
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
	    <input type="text" class="form-control" id="WriterForInsert" name="writter" placeholder="within 8 characters Writer">
	  </div>
	  <div class="form-group">
	    <label for="PwdForInsert">비밀번호(Password)</label>
	    <input type="text" class="form-control" id="PwdForInsert" name="password" placeholder="within 8 characters Password">
	  </div>
	  <input type="button" class="btn btn-success" onclick="doInsert()" value="작성"/>
	  <input type="button" class="btn btn-dark" onclick="clean()" value="취소"/>
	</form>
</body>
</html>