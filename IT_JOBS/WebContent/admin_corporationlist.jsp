<%@page import="com.bb.dto.Paging"%>
<%@page import="com.bb.model.biz.AdminCorpBiz"%>
<%@page import="com.bb.dto.MemberDto"%>
<%@page import="com.bb.dto.CorporationDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
	<%
		response.setContentType("text/html; charset=UTF-8");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*배경색*/
	*{
	box-sizing: border-box;
	}
/*전체 배경색*/	
	body{
	background-color: #FAFAFA;
	color: #424242;
	}
 #corp_table{
    position: relative;
    padding-left: 20px;
 	left: 10px;
	top: 130px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    width: 100%;
    font-size: 11pt;

 }	
.button> input{
	margin-top: 40px;
	width: 100px;
    height: 20px;
    background: #819FF7;
    border-style: none;
    color: white;
    font-size: 10pt;
    position: relative;
    right: -1400px;
    top: -440px;
}
th{
	border-right: 1px solid black;
}
th, td {

        padding: 10px;
        
      }
/*제목 위치*/
#title{
   position: relative;
   left: 50px;
   top: 120px;
   font-size: 11pt;
}
#corp_list{
 padding-bottom: 150px;
}

</style>
</head>
<body>
<%
	AdminCorpBiz cbiz = new AdminCorpBiz();
	int curPage = (Integer)request.getAttribute("curPage");
	int totalCount = (Integer)request.getAttribute("totalCount");
	List<CorporationDto> list = (List<CorporationDto>)request.getAttribute("list");
	
	Paging paging = new Paging(totalCount, curPage);
//	System.out.println("totalPage확인(jsp):"+ paging.getTotalPage());
//	System.out.println("endPage확인(jsp):"+ paging.getEndPage());
%>
<%@ include file="./form/nav_user.jsp" %>
   <div id="corp_list">
      <div id="title">
		<h1>ADMIN >> 기업 회원 조회</h1>
	  </div>		
				<table border="1" height="300" id="corp_table">
				<col width="50"/>
	            <col width="80"/>
	            <col width="150"/>
	            <col width="150"/>
	            <col width="450"/>
	            <col width="200"/>
	            <col width="100"/>
	            <col width="100"/>
	            <col width="110"/>
	            <col width="80"/>
	            <col width="70"/>
	            <col width="90"/>
	            <tr height = "10px">
	            	<th>번호</th>
	                <th>아이디</th>
	                <th>회사 이름</th>
	                <th>전화번호</th>
	                <th>주소</th>
	                <th>이메일</th>
	                <th>사업자등록번호</th>
	                <th>대표이름</th>
	                <th>담당자이름</th>
	                <th>멤버십</th>
	                <th>직원수</th>
	                <th>가입여부</th>
	            </tr>
<%
	for(CorporationDto dto : list){
%> 
              <tr align= "center">
              	  <td><%=dto.getMember_no() %></td>
                  <td><%=dto.getMember_id() %></td>
                  <td><%=dto.getMember_name() %></td>
                  <td><%=dto.getMember_phone() %></td>
                  <td><%=dto.getMember_addr() %></td>
                  <td><%=dto.getMember_email() %></td>
                  <td><%=dto.getCorp_businessno() %></td>
                  <td><%=dto.getCorp_ceo_name() %></td>
                  <td><%=dto.getCorp_board_name() %></td>
                  <td><%=dto.getCorp_membership() %></td>
                  <td><%=dto.getCorp_countemp() %></td>
                  <td><%=dto.getMember_enabled() %></td>
              </tr>
<%
             }
            
%>       
		    </table>
              
                 <div class="button">
                      <input type="button" value="메인" onclick="location.href='adminmain.jsp'"/>
                 </div>
			
			<table id="paging" width="600" align="center" style="position: relative; left: 150px; top:70px;  ">
			<tr>
				<td>
					<%
					 if(paging.getStartPage() > 1){ // 처음, 이전 링크
					%>
					[<a href="paging.do?command=corporationlist&curPage=1">처음</a>]
					
					<%
					 }else{
					%>
					[<span style="color:gray">처음</span>]
					<% 
					 }
					 if(curPage > 1){
					%>
					[<a href="paging.do?command=corporationlist&curPage=<%=curPage-1 %>">◀</a>]
					<%
					 }else{
					%>
					[<span style="color:gray">◀</span>]
					<%
					 }
					%>
					<%
					  for(int iCount = paging.getStartPage(); iCount<= paging.getEndPage(); iCount++){
						 
					%>
					    [<a href="paging.do?command=corporationlist&curPage=<%=iCount %>"><%=iCount %></a>]
					<%
					}
					   if(curPage < paging.getTotalPage()){
					%>
					          [<a href="paging.do?command=corporationlist&curPage=<%=curPage + 1 %>">▶</a>]
					<%
						}else{
					%>
						[<span style="color:gray">▶</span>]	  
					<%		  
					  }
					  if(paging.getEndPage() < paging.getTotalPage()){
					%>    
					     
					[<a href="paging.do?command=corporationlist&curPage=<%=paging.getTotalPage() %>">마지막</a>]
					     
					 <%
					}else{
					 %>      
					  [<span style="color:gray">마지막</span>]
					 <%
					  }	
					 %>	   
				</td>
			</tr>
			
			</table>
	</div>
<%@ include file="./form/footer.jsp" %>
</body>
</html>