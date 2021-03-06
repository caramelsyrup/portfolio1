$(document).ready(function(){
	getpage(1,"","");
	
	//리스트페이지 검색버튼 클릭
	$("#ebtnSearch").on("click",function(){
		getpage(1,$("#efield").val(),$("#eword").val());
	});
	
	// 행사 추가 버튼 누를시
	$("#eventsinsertBtn").click(function(){
		location.href="eventsInsertForm.do";
	});
	
	// 행사 추가 페이지에서 추가 메소드 실행
	$("#eventsInsertBtn").click(function(){
		if($("#eventname").val()==""){
			alert('행사제목 입력하세요.');
			$("#eventname").focus();
			return false;
		}
		if($("#eventdescip").val()==""){
			alert('행사내용 입력하세요.');
			$("#eventdescip").focus();
			return false;
		}
		$("#eventsInsertform").submit();
	});
	
	// 행사 목록으로 가는 버튼
	$("#eventsListBtn").click(function(){
		location.href="eventslist.do";
	});
	
	// 행사 삭제 버튼
	$("#eventDeleteBtn").click(function(){
		if(confirm("해당 행사를 삭제하시겠습니까?")){
			$("#eventDeleteform").submit();
		}
	});
	
	
	// 행사 참석하기 버튼
	$("#attendBtn").click(function(){
		var limit=$('input[name=limit]').val();
		var eventnum=$('#eventnum').val();
		var population = prompt('참여 인원을 입력하세요.',0);
		
		if(parseInt(population)==null || parseInt(population)==0){
			alert('예약이 취소 됩니다.');
			return false;
		}
		if(parseInt(limit)<parseInt(population)){
			alert('가능인원수를 초과 합니다.');
			return false;
		}
		if(parseInt(limit)>=parseInt(population)){
			alert('예약확인 페이지로 이동합니다.');
			location.href="addattendForm.do?eventnum="+eventnum+"&population="+population;
		}
	});
	
	// 참석정보확인 취소
	$("#canceladttendBtn").click(function(){
		history.back();
	});
	// 참석정보확인 결정
	$("#confirmattendBtn").click(function(){
		// 인서트메소드 실행하는 서블릿 실행
		location.href="attendadd.do";
	});
	// 회원 예약 정보 보기
	$("#attendanceList").click(function(){
		location.href="attendanceList.do";
	});
	// 참석정보표에서 삭제
//	function fdelete(num,writter){
//		if(confirm("["+writter+"]의 게시물을 삭제 할까요?")){
//			$.get("delete.gb",
//					{"num":num,"writter":writter},
//					function(d){
//						$("#result").html(d);	
//					}
//			)	// $.get
//		}	//confirm
//	}	// fdelete
	
});

function getpage(pageNum,efield,eword){
	
	$.get("eventslist.do",
			  {"epageNum":pageNum,"efield":efield,"eword":eword}, 
			  function(b){
				  // d =  eventslist.do 서버 로직의 결과를 eventslist.jsp 담은 데이터 저장됨
				  var dummyDom = document.getElementsByClassName("dummy")[0];
				  // 가공을 위한 dummy div tag에 저장
				  dummyDom.innerHTML = b;
				  // 그림 및 페이정보만 담김 태그 데이터들을 저장
				  var resultDom = dummyDom.getElementsByClassName("eone-column")[0].innerHTML;
				  // 우리가 노출할 화면에 저장
				  document.getElementsByClassName("eone-column")[0].innerHTML = resultDom;
				  // 저장후 데이터 날림
				  dummyDom.innerHTML = "";
			  }
		);

}