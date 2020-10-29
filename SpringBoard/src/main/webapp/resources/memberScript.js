
	
$(document).ready(function(){
	// 회원가입
	// 중복확인 버튼
	$("#btnCheckID").on("click",function(){
		// 아이디 체크
		var inputID =$("#ID").val();
		// 아이디 없다면,
		if(inputID==''){
			alert("아이디를 입력하세요!");
		}else{
			$.ajax({
				type:"get",
				url:"/board/member/checkID/"+inputID,
			})	// ajax
			.done(function(resp){
				if(resp!=0){	// 기존 db에 아이디 없음
					alert('사용할 수 있습니다.');
				}else{			// 기존 db에 아이디 있음
					// 초기화
					document.getElementById('ID').value = null;
					alert('아이디 존재 합니다.');
				}
			})	// 콜백성공
			.fail(function(error){
				alert('실패');
			});	// 콜백실패
		}	// if문
	});	// 버튼 클릭
	
	
	// 회원가입 우편번호 검색 버튼
	$("#btnAddrNum").on("click",function(){
		window.open("/board/member/addrCheck/","","width=800 height=600");
	});
	
	// 우편번호 검색 창에서 주소 검색
	$("#btnAddrChk").on("click",function(){
		var inputAddr = $("#addrText").val().trim();
		if(inputAddr==''){
			// 초기화
			document.getElementById('addrText').value = null;
			// 포커스두기
			document.getElementById('addrText').focus();
			// 창띄우기
			alert('주소를 기입하세요!');
		}else{
			$.post("/board/member/address/",
					{"dong":inputAddr},
					function(data){
						var listStr="";
						$.each(data,function(key,val){
							listStr+=
								`<tr>
									<td>${val.zipcode}</td>
									<td>${val.sido}</td>
									<td>${val.gugun}</td>
									<td>${val.dong}</td>
									<td>${val.bunji}</td>
								</tr>
								`;
						});
						$("#area tbody").html(listStr);
					}	// 콜백함수
			);	// post
		}	// if문
	});	// btn주소검색
	
	// 주소 검색 결과를 클릭하면, 창이 닫히고, 상세주소에 자동 기입.ADDR
	$("#area").on("click","tr",function(){
		var address = $("td:eq(0)",this).text()+" "+$("td:eq(1)",this).text()+" "+$("td:eq(2)",this).text()+" "+$("td:eq(3)",this).text()+" "+$("td:eq(4)",this).text();
		
		$(opener.document).find("#ADDR").val(address);
		
		if($(opener.document).find("#ADDR").val()!='')
			self.close();
	});
	
	//회원가입 버튼
	$("#btnJoin").on("click",function(){
		if($("#ID").val().trim()==''){
			alert('아이디 입력하세요');
			return false;
		}
		 if($("#PASS").val().trim()==''){
			alert('비밀번호 입력하세요');
			return false;
		}
		 if($("#NAME").val().trim()==''){
			alert('이름 입력하세요');
			return false;
		}
		 if($("#ADDR").val().trim()==''){
			alert('주소 입력하세요');
			return false;
		}
		 if($("#MEMO").val().trim()==''){
			alert('메모 입력하세요');
			return false;
		}
			$("#insertForm").submit();
	});
	
	// 로그인버튼
	$("#btnLogin").click(function(){
		
		var Lid=$("#LID").val();
		var Lpass=$("#LPASS").val();
		
		if(Lid.trim()==""){
			alert('아이디 입력하세요');
			return false;
		}
		if(Lpass.trim()==""){
			alert('비밀번호 입력하세요');
			return false;
		}
		/*$("#loginForm").submit();*/
		
		$.ajax({
			type:"post",
			url:"/board/member/login",
			data:{"LID":Lid,"LPASS":Lpass}
		})
		.done(function(resp){
			alert('성공'+resp);
		})
		.fail(function(error){
			alert('실패'+error);
		});
	});
	
});	// document

