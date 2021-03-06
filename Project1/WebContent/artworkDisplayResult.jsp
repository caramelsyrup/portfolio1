<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>작품 전시관</h2>
</div>
<div id="one-column">
	<div id="content">
		<form name = "search" id = "search">
			<select name="field" id="field">
				<option value = "arttitle">제목</option>
				<option value = "artmaker">작가</option>
			</select>
			<input type = "text" name = "word" id = "word">
			<input type = "button" value = "찾기" id = "btnSearch"> 
		</form>
	</div>
</div>
<div class="one-column" id="one-column">
	<div id="area">
		<h2>소장품 총 개수 : <span id="cntSpan">${count}</span> 개</h2>
		<c:forEach items="${artlist}" var="art">
			<a href="artworkDetail.do?artid=${art.artid}"><img src="<c:url value="/images/${art.filename}"/>" style="width: 350px;height: 600px;" ></a>
		</c:forEach>
	</div>
	<div align = "center">
		<c:if test = "${pu.startPage>pu.pageBlock}"> <!-- 이전-->
			<a href = "javascript:getData(${pu.startPage-pu.pageBlock},'${pu.field}','${pu.word}')">[이전]</a>
	  	</c:if>
	  	<c:forEach begin ="${pu.startPage}" end = "${pu.endPage}" var = "i"> <!-- 이전-->
			<c:if test ="${i==pu.currentPage}"> <!-- 현재페이지-->
	 			<c:out value = "${i}"/>
	  		</c:if>
	  		<c:if test = "${i!=pu.currentPage}"> <!-- 현재페이지 아닌 경우 링크 부여-->
	  			<a href = "javascript:getData(${i},'${pu.field}','${pu.word}')">${i}</a>
	  		</c:if>
	  	</c:forEach>
	  	<c:if test = "${pu.endPage < pu.totPage}"> <!-- 다음-->
	  		<a href = "javascript:getData(${pu.endPage+1},'${pu.field}','${pu.word}')">[다음]</a>
	  	</c:if>
	</div>
</div>

<div class="dummy" style="display:none;">
</div>
<%@ include file="../include/footer.jsp"%>