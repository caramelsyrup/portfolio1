<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
	<!-- 아이디 -->
	<form action="insertUser" method="post" id="insertForm">
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="basic-addon1">아이디</span>
		  </div>	
		  <div class="input-group-prepend">
		    <input class="btn btn-outline-secondary" type="button" id="btnCheckID" value="중복검사"/>
		  </div>
		  <input type="text" class="form-control" id="ID" name="ID" placeholder="8자 이내" aria-label="Example text with button addon" aria-describedby="button-addon1">
		</div>
		<!-- 비밀번호 -->
		<div class="input-group mb-3">
		 <div class="input-group-prepend">
		    <span class="input-group-text">비밀번호</span>
		  </div>
		  <input type="text" class="form-control" id="PASS" name="PASS" placeholder="10자이내" aria-label="Recipient's username" aria-describedby="button-addon2">
		</div>
		<!-- 이름 -->
		<div class="input-group mb-3">
		 <div class="input-group-prepend">
		    <span class="input-group-text">이름(성명)</span>
		  </div>
		  <input type="text" class="form-control" id="NAME" name="NAME" placeholder="영문,국문" aria-label="Recipient's username" aria-describedby="button-addon2">
		</div>
		<!-- 주소, 우편번호 -->
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text">우편번호</span>
		  </div>
		  <div class="input-group-append">
		    <button class="btn btn-outline-secondary" type="button" id="btnAddrNum">검색</button>
		  </div>
		</div>
		<!-- 주소, 구체적기재 -->
		<div class="input-group mb-3">
		 <div class="input-group-prepend">
		    <span class="input-group-text">상세 주소</span>
		  </div>
		  <input type="text" class="form-control" id="ADDR" name="ADDR" placeholder="자동기입됩니다." aria-label="Recipient's username" aria-describedby="button-addon2">
		</div>
		<!-- 하고싶은 말 -->
		<div class="input-group mb-3">
		 <div class="input-group-prepend">
		    <span class="input-group-text">메모</span>
		 </div>
		 <input type="text" class="form-control" id="MEMO" name="MEMO" placeholder="간단한 소개" aria-label="Recipient's username" aria-describedby="button-addon2">
		</div>
		<!-- 버튼 -->
		<div class="container">
	 	 <div class="row">
		    <div class="col-3"> <input class="btn btn-primary" type="button" id="btnJoin" value="회원가입"></div>
		    <div class="col-2"> <input class="btn btn-secondary" type="reset" value="취소"></div>
		 </div>
		</div>
	</form>
</body>
</html>