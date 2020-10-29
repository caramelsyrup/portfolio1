package com.myboard.util;

public class PageAction {
	// 페이징 처리를 위해서 클래스와 함수를 만듦.
		public String paging(int count,int pageSize,int currentPage,String field,String word) {
			// 자바스크립트 페이지에서 이루어져야함
			// sb에 넣기 위해서 미리 문장을 만들어 놓음.
			String file = "javascript:getData(";
			int pageCount = count/pageSize+(count%pageSize==0?0:1);
			int pageBlock = 3;
			int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			int endPage = startPage+pageBlock-1;
			if(endPage>pageCount) endPage = pageCount;
			
			StringBuilder sb = new StringBuilder();
			if(count>0) {
				// 이전
				if(startPage>pageBlock) {
					// <a href=getData(1,'name','홍길동');>[이전]</a> 만들기
					sb.append("<a href=");
					sb.append(file);
					sb.append(startPage-pageBlock);
					sb.append(",'"+field);
					sb.append("','"+word+"');");
					sb.append(">[이전]</a>");
					
				}
			// 페이지번호
				for(int i=startPage;i<=endPage;i++) {
					if(i==currentPage) {	// 현재 페이지
						sb.append("["+i+"]");
					}else {	// 현재 페이지 아님
						sb.append("<a href=");
						sb.append(file);
						sb.append(i);
						sb.append(",'"+field);
						sb.append("','"+word+"')");
						sb.append(">"+i+"</a>");
					}
				}
			// 다음
				if(endPage<pageCount) {
					// <a href=getData(1,'name','홍길동');>[다음]</a> 만들기
					sb.append("<a href=");
					sb.append(file);
					sb.append(startPage+pageBlock);
					sb.append(",'"+field);
					sb.append("','"+word+"');");
					sb.append(">[다음]</a>");
				}
				
			}
			return sb.toString();
			
		}
}
