<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>공지사항</h2>
</div>
<div id="one-column">
	<div id="content">
		<form name = "esearch" id = "esearch">
			<select name="bfield" id="bfield">
				<option value = "subject">제목</option>
				<option value = "content">내용</option>
			</select>
			<input type = "text" name = "bword" id = "bword">
			<input type = "button" value = "찾기" id = "bbtnSearch"> 
		</form>
		<br>
		<h2>총 <span >${bcount}</span>개의 글</h2>
		<c:if test="${sessionScope.grade==1}">
			<input type="button" class="allbutton" value="게시글추가" id="boardinsertBtn">
		</c:if>
	</div>
</div>

<div class="bone-column" id="bone-column">
	<div id="content">
		<table border="2">
			<tr>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>조회수</th>
				<c:if test="${sessionScope.grade==1}">
					<th>삭제</th>
				</c:if>
			</tr>
			<c:forEach items="${barr}" var="bo">
				<tr>
					<td>${bo.userid}</td>
					<td><a href="boardDetail.do?bnum=${bo.bnum}">${bo.subject}</a></td>
					<td>${bo.reg_date}</td>
					<td>${bo.readcount}</td>
				<c:if test="${sessionScope.grade==1}">
					<td><a href="boardDelete.do?bnum=${bo.bnum}">삭제</a></td>
				</c:if>
				</tr>
			</c:forEach>
		</table>	
	</div>
	<div align = "center">
		<c:if test = "${pu.startPage>pu.pageBlock}"> <!-- 이전-->
			<a href = "javascript:getbpage(${pu.startPage-pu.pageBlock},'${pu.field}','${pu.word}')">[이전]</a>
	  	</c:if>
	  	<c:forEach begin ="${pu.startPage}" end = "${pu.endPage}" var = "i"> <!-- 이전-->
			<c:if test ="${i==pu.currentPage}"> <!-- 현재페이지-->
	 			<c:out value = "${i}"/>
	  		</c:if>
	  		<c:if test = "${i!=pu.currentPage}"> <!-- 현재페이지 아닌 경우 링크 부여-->
	  			<a href = "javascript:getbpage(${i},'${pu.field}','${pu.word}')">${i}</a>
	  		</c:if>
	  	</c:forEach>
	  	<c:if test = "${pu.endPage < pu.totPage}"> <!-- 다음-->
	  		<a href = "javascript:getbpage(${pu.endPage+1},'${pu.field}','${pu.word}')">[다음]</a>
	  	</c:if>
	</div>
</div>
<div class="dummy" style="display:none;">
</div>
<%@ include file="../include/footer.jsp"%>