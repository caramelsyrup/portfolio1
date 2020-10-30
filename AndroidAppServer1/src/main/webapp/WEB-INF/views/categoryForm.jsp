<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<form action="inputCategory" method="post">
<div class="input-group mb-3">
	<div class="input-group">
	  <input type="text" class="form-control" id="cname" name="cname" placeholder="카테고리 입력란" aria-label="Recipient's username with two button addons" aria-describedby="button-addon4">
	  <div class="input-group-append" id="button-addon4">
	  <input class="btn btn-success" type="button" id="addCategory" onclick='inputCate()' value="추가"/>
	  </div>
	</div>
</div>
</form>
</body>
</html>