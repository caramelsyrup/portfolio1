<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>BoardList</title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
	<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
	<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
	<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>
	<h2 class="h2">전체 게시글 목록</h2>
	<form action="sboardList">
		<table class="table">
		  <thead class="thead-dark">
		  	<tr>
		  		<th scope="col" colspan="6" style="text-align: center;">${count}</th>
		  		<th scope="col" colspan="1" style="text-align: center;"><a href="boardInsert" class="btn btn-primary">글쓰기</a></th>
		  	</tr>
		    <tr>
		      <th scope="col">번호</th>
		      <th scope="col">인덱스</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회수</th>
		      <th scope="col">삭제</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list}" var="board">
			    <tr>
			      <th scope="row">${board.num}</th>
			      <td><c:out value="${rowNo-st.index}"></c:out></td>
			      <td><a href='/security/board/view?num=${board.num}'><c:out value="${board.title}"/><b>[<c:out value="${board.replyCnt}"></c:out>]</b></a></td>
			      <td>${board.writter}</td>
			      <td>${board.regdate}</td>
			      <td>${board.hitcount}</td>
			      <td><a href='javascript:delList(${board.num})'>삭제</a></td>
			    </tr>
		    </c:forEach>
		    <tr>
				<td colspan="1">
					<select name="field">
						<option>==선택==</option>
						<option value="title">글제목</option>
						<option value="writter">작성자</option>
					</select>
				</td>
				<td colspan="3">
					<input type="text" name="word" id="word">
				</td>
				<td colspan="1">
					<input type="submit" value="검색">
				</td>
			</tr>
		  </tbody>
		  <tfoot>
		  
		  </tfoot>
		</table>
	</form>
</body>
</html>