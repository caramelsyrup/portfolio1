<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>미술관 행사</h2>
</div>
<div id="one-column">
	<div id="content">
		<form name = "esearch" id = "esearch">
			<select name="efield" id="efield">
				<option value="eventname">제목</option>
				<option value="eventhost">주최</option>
			</select>
			<input type = "text" name = "eword" id = "eword">
			<input type = "button" value = "찾기" id = "ebtnSearch"> 
		</form>
		<br>
		<h2>총 <span >${ecount}</span>개의 행사</h2>
		<c:if test="${sessionScope.grade==1}">
			<input type="button" class="allbutton" value="행사추가" id="eventsinsertBtn">
		</c:if>
	</div>
</div>

<div class="eone-column" id="eone-column">
	<div id="content">
		<c:forEach items="${eventlist}" var="event">
			<a href="eventsDetail.do?eventnum=${event.eventnum}"><img src="<c:url value="/images/${event.filename}"/>" style="width: 350px; height: 600px"></a>
		</c:forEach>	
	</div>
	<div align = "center">
		<c:if test = "${pu.startPage>pu.pageBlock}"> <!-- 이전-->
			<a href = "javascript:getpage(${pu.startPage-pu.pageBlock},'${pu.field}','${pu.word}')">[이전]</a>
	  	</c:if>
	  	<c:forEach begin ="${pu.startPage}" end = "${pu.endPage}" var = "i"> <!-- 이전-->
			<c:if test ="${i==pu.currentPage}"> <!-- 현재페이지-->
	 			<c:out value = "${i}"/>
	  		</c:if>
	  		<c:if test = "${i!=pu.currentPage}"> <!-- 현재페이지 아닌 경우 링크 부여-->
	  			<a href = "javascript:getpage(${i},'${pu.field}','${pu.word}')">${i}</a>
	  		</c:if>
	  	</c:forEach>
	  	<c:if test = "${pu.endPage < pu.totPage}"> <!-- 다음-->
	  		<a href = "javascript:getpage(${pu.endPage+1},'${pu.field}','${pu.word}')">[다음]</a>
	  	</c:if>
	</div>
</div>
<div class="dummy" style="display:none;">
</div>
<%@ include file="../include/footer.jsp"%>