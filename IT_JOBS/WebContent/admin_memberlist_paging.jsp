<%@page import="com.bb.dto.Paging"%>
<%@page import="com.bb.model.biz.AdminMemberBiz_paging"%>
<%@page import="com.bb.dto.MemberDto"%>
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
 #member_table{
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
    top: -400px;
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
#member_list{
 padding-bottom: 150px;
}
 
</style>
</head>
<body>
<%
	AdminMemberBiz_paging mbiz = new AdminMemberBiz_paging();
	int curPage = (Integer)request.getAttribute("curPage");
	int totalCount = (Integer)request.getAttribute("totalCount");
	List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
	
	Paging paging = new Paging(totalCount, curPage);
	
  
%>
<%@ include file="./form/nav_user.jsp" %>
	<div id="member_list">	
		<div id="title">	
			<h1>ADMIN >> 일반 회원 조회</h1>
		</div>
			
			<table border="1" cellpadding="2" height="100" id="member_table">
			<col width="50"/>
            <col width="100"/>
            <col width="100"/>
            <col width="150"/>
            <col width="150"/>
            <col width="400"/>
            <col width="200"/>
            <col width="200"/>
            <col width="100"/>
            <col width="100"/>
            <tr>
                <th>번호</th>
                <th>아이디</th>
                <th>이름</th>
                <th>생일</th>
                <th>우편번호</th>
                <th>주소</th>
                <th>전화번호</th>
                <th>이메일</th>
                <th>가입여부</th>
                <th>등급</th>
            </tr>
<%
	for(MemberDto dto : list){
%> 
              <tr align="center">
                  <td><%=dto.getMember_no() %></td>
                  <td><%=dto.getMember_id() %></td>
                  <td><%=dto.getMember_name() %></td>
                  <td><%=dto.getMember_birthday() %></td>
                  <td><%=dto.getMember_postcode() %></td>
                  <td><%=dto.getMember_addr() %></td>
                  <td><%=dto.getMember_phone() %></td>
                  <td><%=dto.getMember_email() %></td>
                  <td><%=dto.getMember_enabled().equals("Y")?"가입" : "탈퇴" %></td>
                  <td><%=dto.getMember_role() %></td>
              </tr>
<%
             }
%>           
              </table>
                 <div class="button">
                      <input type="button" value="메인" onclick="location.href='adminmain.jsp'"/>
				 </div>
			<table width="600" align="center" style="position: relative; left: 150px; top:90px;">
			<tr>
				<td>
					<%
					 if(paging.getStartPage() > 1){ // 처음, 이전 링크
					%>
					[<a href="paging.do?command=memberlist&curPage=1">처음</a>]
					<% 
					 }
					 if(curPage > 1){ // 현재 페이지가 1보다 크면 이전 페이지가 존재 
					%>
					[<a href="paging.do?command=memberlist&curPage=<%=curPage-1 %>">◀</a>]
					<%
					 }
					%>
			
					<%
					  for(int iCount = paging.getStartPage(); iCount<= paging.getEndPage(); iCount++){
						 
					%>
					  [<a href="paging.do?command=memberlist&curPage=<%=iCount %>"><%=iCount %></a>]   
					<%
					  }
						if(curPage< paging.getTotalPage()){
					%>      
					      [<a href="paging.do?command=memberlist&curPage=<%=curPage + 1 %>">▶</a>]
					     
					 <%
						  }
						if(paging.getEndPage() < paging.getTotalPage() ){
					 %>     
					  [<a href="paging.do?command=memberlist&curPage=<%=paging.getTotalPage() %>">마지막</a>]
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