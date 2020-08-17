$(document).ready(function(){
	// 처음 페이지로 초기화
	 getData(1,"","");
	
	//리스트페이지 검색버튼 클릭
	$("#btnSearch").on("click",function(){
		getData(1,$("#field").val(),$("#word").val());
	});
	
	// 작품 추가
	$("#artworkInsertBtn").click(function(){
		// 작품 입력
		if($("#arttitle").val()==""){
			alert('작품제목을 입력하세요.');
			$("#arttitle").focus();
			return false;
		}
		if($("#afilename").val()==""){
			alert('파일 이름을 입력하세요.');
			$("#afilename").focus();
			return false;
		}
		$("#artowrkInsertform").submit();
	})
	
	// 작품 리스트로 가는 버튼
	$("#artworkListBtn").click(function(){
		location.href="artworkList.do";
	});
	
	// 작품 상세보기에서 삭제
	$("#artworkDeleteBtn").click(function(){
		if(confirm("해당 작품을 삭제하시겠습니까?")){
			$("#artworkDeleteform").submit();
		}
	});
	
});

function getData(pageNum,field,word){
	
	$.get("artworkList.do",
			  {"pageNum":pageNum,"field":field,"word":word}, 
			  function(d){
				  // d =  artworkList.do 서버 로직의 결과를 artworkList.jsp 담은 데이터 저장됨
				  var dummyDom = document.getElementsByClassName("dummy")[0];
				  // 가공을 위한 dummy div tag에 저장
				  dummyDom.innerHTML = d;
				  // 그림 및 페이정보만 담김 태그 데이터들을 저장
				  var resultDom = dummyDom.getElementsByClassName("one-column")[0].innerHTML;
				  // 우리가 노출할 화면에 저장
				  document.getElementsByClassName("one-column")[0].innerHTML = resultDom;
				  // 저장후 데이터 날림
				  dummyDom.innerHTML = "";
			  }
		);
}
