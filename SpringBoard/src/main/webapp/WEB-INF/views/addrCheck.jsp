<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>		
<!-- Content -->
<div class="container">
  <div class="row align-items-start">
    <div class="col">
      <h2 class="h2">주소검색</h2>
      <input type="text" id="addrText" name="addrText" size="20" placeholder="동을 넣어주세요.">
      <input class="btn btn-info" type="button" id="btnAddrChk" value="주소검색">
    </div>
  </div>
  <div class="row align-items-center">
    <div class="col">
     <div class="accordion" id="accordionExample">
	  <div class="card">
	    <div class="card-header" id="headingOne">
	      <h2 class="mb-0">
	        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	          주소 검색 결과
	        </button>
	      </h2>
	    </div>
	    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
	     <div class="card-body">
	        <div id="area">
	        	<table class="table table-striped"><tbody></tbody></table>
	        </div>	       
	     </div>
	    </div>
	  </div>
	 </div>
    </div>
  </div>
</div>
