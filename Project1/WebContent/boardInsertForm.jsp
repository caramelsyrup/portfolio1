<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>    
<div id="welcome">
	<h2>게시글 작성</h2>
</div>
	<div id="one-column">
		<div id="content">
				<h2>${writter}님 반갑습니다.</h2>
				<form action="boardInsert.do" id="boardInsertForm" method="post">
					<table>
						<tr>
							<th>아이디</th>
							<td><input type="text" value="${writter}" readonly="readonly" name="buserid" id ="buserid" size=8></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="subject" id="subject" size="47" style="font-size: 20px"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea rows="5" cols="60" name="bcontent" id="bcontent" style="font-size: 15px"></textarea></td>
						</tr>				
					</table>
					<input type="button" class="allbutton" value="작성완료" id="boardInsertBtn">
					<input type="button" class="allbutton" value="게시글목록" id="boardlistBtn">
				</form>
		</div>
	</div>
<%@ include file="../include/footer.jsp"%>