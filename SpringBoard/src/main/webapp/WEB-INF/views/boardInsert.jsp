<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
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
	<div id="listView">
	<h2></h2>
	<table class="table table-striped">
		<thead class="thead-dark"></thead>
		<tbody></tbody>
	</table>
</div>
</body>
</html>