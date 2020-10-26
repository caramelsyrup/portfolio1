$(function(){

});

// 지우기
function clean(){
	var Str ="";
	$("#insertView").html(Str);
}

// insert 폼 띄우는 함수
function insert(){
	$.get("boardInsert",
			{},
				function(resp){
					var inStr ="";
					inStr +=resp;
					$("#insertView").html(inStr);
				}
	);
}

// 추가하기 기능 실행 후 리스트화면 띄우기
function doInsert(){
	$.post("boardInsert",
			{"title":$("#TitleForInsert").val(),"content":$("#ContentForInsert").val(),"writter":$("#WriterForInsert").val(),"password":$("#PwdForInsert").val()},
				function(resp){
					if(resp==1){
						getList();
					}else{
						alert("서버오류!");
					}
				}
	);
}

// getList 정의
function getList(field,word){
	$.get("boardList",
			{"field":field,"word":word},
			function(resp){	// List형 하나의 데이터만 받기에
				$("#listView h2").html("전체보기");
				var listHead = "";
				listHead +='<tr><th scope="col">번호</th><th scope="col">작성자</th><th scope="col">제목</th><th scope="col">내용</th><th scope="col">작성일</th><th scope="col">조회수</th><th scope="col">삭제</th></tr>';
				$("#listView thead").addClass('thead-dark').html(listHead);
				var listStr = "";
				$.each(resp,function(key,val){
					listStr +=
					`<tr>
						<td>${val.num}</td>
						<td><a href='javascript:void(0)' onclick='getView(${val.num})'>${val.writter}</a></td>
						<td>${val.title}</td>
						<td>${val.content}</td>
						<td>${val.regdate}</td>
						<td>${val.hitcount}</td>
						<td><a href='javascript:void(0)' onclick='delList(${val.num})'>삭제</a></td>
					</tr>
					`;
				});	// each문				
				$("#listView tbody").html(listStr);	// 해당 영역에 출력
			}	// callback function
	);	// $.get
}	// getList

//상세보기
function getView(num){
	$.get("view",
			{"num":num},
				function(resp){
					$("#viewByNum h2").html("상세보기");
					var viewHead ="";
					viewHead +='<tr><th scope="col">번호</th><th scope="col">작성자</th><th scope="col">제목</th><th scope="col">내용</th><th scope="col">작성일</th><th scope="col">조회수</th><th scope="col">삭제</th></tr>';
					$("#viewByNum thead").html(viewHead);
					
					var viewStr="";
					viewStr +="<tr><td>"+resp.num+"</td>"
					viewStr +="<td>"+resp.writter+"</td>"
					viewStr +="<td>"+resp.title+"</td>"
					viewStr +="<td>"+resp.content+"</td>"
					viewStr +="<td>"+resp.regdate+"</td>"
					viewStr +="<td>"+resp.hitcount+"</td>"
					viewStr +="<td><a href='boardUpdate?num="+resp.num+"'>수정하기</a></td></tr>";
					$("#viewByNum tbody").html(viewStr);
				}
	);
}

// 삭제하기
function delList(num){
	$.get("boardDelete",{"num":num},
		function(resp){
			if(resp=="1"){
				getList("","");
			}else{
			}
		}
	);
}
