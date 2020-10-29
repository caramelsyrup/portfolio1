<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
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
			      <td><a href='/board/reply/${board.num}'><c:out value="${board.title}"/><b>[<c:out value="${board.replyCnt}"></c:out>]</b></a></td>
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