$(function(){
	// 카테고리추가폼 띄우기
	$("#option1").on("click",function(){
		$.ajax({
			type:"get",
			url:"categoryIn",
		})
		.done(function(resp){
			var Str="";
			Str+= resp;
			$("#result1").html(Str);
		})
		.fail(function(error){
			alert('오류!'+error);
		});
	});

});

	function inputCate(){
		if($("#cname").val().trim()==''){
				alert('입력해주세요!');
			}else{
				$.post(
					"inputCategory",
					{"cname":$("#cname").val()},
					function(resp){
						alert(resp);
					}
				);
			}
	}