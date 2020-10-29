<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<h2>수정하기 양식</h2>
	<div>
		<form action="boardUpdate" method="post">
		  <div class="form-group">
		    <label for="NumForInsert">번호(Num)</label>
		    <input type="number" class="form-control" id="NumForInsert" name="bnum" value="${user.num}" readonly="readonly">
		  </div>
		  <div class="form-group">
		    <label for="TitleForInsert">제목(Title)</label>
		    <input type="text" class="form-control" id="TitleForInsert" name="title" value="${user.title}">
		  </div>
		  <div class="form-group">
		    <label for="ContentForInsert">내용(Content)</label>
		    <textarea class="form-control" id="ContentForInsert" rows="3" cols="20" name="content">${user.content}</textarea>
		  </div>
		  <div class="form-group">
		    <label for="WriterForInsert">작성자(Writer)</label>
		    <input type="text" class="form-control" id="WriterForInsert" name="writter" value="${user.writter}">
		  </div>
		  <div class="form-group">
		    <label for="PwdForInsert">비밀번호(Password)</label>
		    <input type="password" class="form-control" id="PwdForInsert" name="password" value="${user.password}">
		  </div>
		  <div class="form-group">
		    <label for="hitcountForInsert">조회수(hitcount)</label>
		    <input type="number" class="form-control" id="hitcountForInsert" name=hitcount value="${user.hitcount}" readonly="readonly">
		  </div>
		  <input type="submit" class="btn btn-success" value="작성"/>
		  <input type="button" class="btn btn-dark" onclick="location.href='sboardList'" value="돌아가기">
		</form>
	</div>
	<div id="area">
		<table class="table">
			<tbody></tbody>
		</table>
	</div>
	 <div class="form-group">
	    <input type="text" id="userid" name="userid">
	    <textarea class="form-control" id="msg" rows="3" cols="20" name="content"></textarea>
	    <input type="button" class="btn btn-warning" value="댓글쓰기" id="com">
	 </div>

	<script>
			// 댓글 추가 함수
			$("#com").on("click",function(){
				
				var data={userid:$("#userid").val(),content:$("#msg").val(),bnum:$("#NumForInsert").val()};
			
				$.ajax({
					type:"post",
					url:"/board/reply/commentInsert",
					contentType:"application/json;charset=utf-8",
					data:JSON.stringify(data)
					}).done(function(resp){
						alert("성공"+resp);
						init();
					}).fail(function(error){
						alert("실패"+error);
					});
			});
		
		// 댓글 삭제 함수
/* 		function cdel(cnum){
			$.get("cdelete",{"cnum":cnum},
					function(resp){
						if(resp!=0){
							init();	
						}else{
							alert("실패!");
						}
					}
			);
		} 
*/		
		function cdel(cnum){
			$.ajax({
				type:'DELETE',
				url:"/board/reply/cdelete/"+cnum,
				contentType:"application/json;charset=utf-8" // 서버에 데이터를 보낼때 헤더 설정. 'dataType:'로 설정하는 부분은 리턴받을 시 설정.
				})
				.done(function(resp){
					alert("성공!");
						init();	
				})
				.fail(function(error){
					alert("실패!");
				});
		}
		
		// 댓글 보기 함수
		var init = 
			function(){
				$.ajax({
					type:"get",
					url:"/board/reply/commentList",
					/* dataType:json,			// 리턴 받아오는 데이터 형태를 정해줌. */
					data:{"bnum":$("#NumForInsert").val()}
					/* contentType:"application/json;charset=utf-8" */
				})
				.done(function(resp){	// 콜백 함수 부분
					var Str ="";
					$.each(resp,function(key,val){
						Str +="<li data-cnum=>"+val.cnum+"</li>";
						Str +="<div class='commentArea'>";
						Str +=val.userid+"<br>";
						Str +=val.content+"<br>";
						Str +=val.regdate+"<br>";
						Str +="<a href='javascript:cdel("+val.cnum+")'>삭제</a></hr>";
						/* Str +="<tr><th scope='row'>"+val.userid+"</th><td>"+val.content+"</td>";
						Str +="<td>"+val.regdate+"</td>";
						Str +="<td><a href='javascript:void(0)' onclick='cdel("+val.cnum+")'>삭제</a></tr>"; */
					});	// each문	
					$("#area tbody").html(Str);
				})
				.fail(function(error){
					alert("실패");
				});	
			}
		init();
	</script>
</body>
</html>