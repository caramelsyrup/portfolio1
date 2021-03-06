<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>    
<div id="welcome">
	<h2>회원 상세 정보</h2>
</div>
	<div id="one-column">
		<div id="content">
				<h2>${memberDetail.userid}님 가입정보</h2>
				<form action="memberupdate.do" id="memberUpdateform">
				<input type="hidden" value="${memberDetail.num}" name="usernum" id="usernum">
				<ul class="list-style">									
					<li>							
						<label>아이디 : </label>
						<input type="text" value="${memberDetail.userid}" readonly="readonly" name="upuserid" id ="upuserid" size=8>
					</li>
					<li>							
						<label>비밀번호 : </label>
						<input type="text" value="${memberDetail.userpwd}" name="upuserpwd" size=7>
					</li>
					<li>							
						<label>성명 : </label>
						<input type="text" value="${memberDetail.username}" name="upusername" size=5>
					</li>
					<li>							
						<label>연락처 : </label>
						<input type="text" value="${memberDetail.usertel}" name="upusertel" size=8>
						
					</li>
					<li>							
						<label>이메일 : </label>
						<input type="text" value="${memberDetail.useremail}" name="upuseremail">
						
					</li>
					<li>							
						<label>우편번호 : </label>
						<input type="text" value="${memberDetail.userzipcode}" name="upuserzipcode" size=4>
					</li>
					<li>						
						<label>주소 : </label>
						<input type="text" value="${memberDetail.useraddr}" name="upuseraddr" size=50>
					</li>
				</ul>
				<c:if test="${sessionScope.grade==1}">
					<input type="button" class="allbutton" value="회원목록" id="listmemberBtn">
				</c:if>
				<input type="button" class="allbutton" value="수정하기" id="updatememberBtn">
				<input type="button" class="allbutton" value="회원탈퇴" id="deletememberBtn">
				</form>
		</div>
	</div>
<%@ include file="../include/footer.jsp"%>