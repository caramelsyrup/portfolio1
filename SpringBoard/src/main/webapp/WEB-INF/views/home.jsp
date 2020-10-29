<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ page session="false" %>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/board/resources/boardScript.js"></script>
<h1 class="h1">	Hello world! </h1>
<h3 class="h3"><span class="badge badge-pill  badge-success">${serverTime}</span></h3>
<button type="button" class="btn btn-primary" onclick="insert()">추가</button>
<button type="button" class="btn btn-danger" onclick="getList()">리스트</button>

<div id="insertView"></div>
<div id="listView">
	<h2></h2>
	<table class="table table-striped">
		<thead class="thead-dark"></thead>
		<tbody></tbody>
	</table>
</div>
<div id="viewByNum">
	<h2></h2>
	<table class="table table-bordered">
		<thead></thead>
		<tbody></tbody>
	</table>
</div>
</body>
</html>
