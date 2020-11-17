<%@page import="com.bb.model.biz.AdminMemberBiz"%>
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
	AdminMemberBiz mbiz = new AdminMemberBiz();
    String strPg = request.getParameter("pg"); //controller에서 pg=1 값 넘어옴. (첫페이지 뜰 수 있게)
	
    int rowSize = 10; //한 페이지에 보여줄 데이터의 수 
    int pg = 1; //페이지, 초기값 1
    
    if(strPg !=null){
    	pg = Integer.parseInt(strPg); //저장
    }	
    int from = (pg * rowSize) - (rowSize-1);  // 현재 페이지의 게시물 시작 행번호(게시물 번호 x) -> 메소드에서 begin
    int to = (pg * rowSize);    //현재 페이지의 게시물 끝 행번호(게시물 번호 x)  -> 메소드에서 end
    
    List<MemberDto> list = mbiz.memberList(from, to);
    
    int total = mbiz.getMemberTotal(); //총 게시물 수
    int allPage = (int)Math.ceil(total/(double)rowSize); // 페이지 수 
    // int totalPage = total/rowSize + (total%rowSize == 0? 0 : 1); 페이지 그룹 수
    int block = 4; // 한페이지에 보여줄 범위 <<[1][2][3]>>
    
   //System.out.println("전체 페이지수 : " + allPage);
    //System.out.println("현재 페이지수 :" + strPg);
    
    int fromPage = ((pg-1)/block*block) + 1; // 보여줄 페이지의 시작
    int toPage = ((pg-1)/block*block) + block; // 보여줄 페이지의 끝
    if(toPage> allPage){
    	toPage = allPage;
    }
    //System.out.println("페이지시작: " + fromPage + "/페이지 끝 : "+ toPage);
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
					 if(pg>block){ // 처음, 이전 링크
					%>
					[<a href="admin_memberlist.jsp?pg=1">◀◀</a>]
					[<a href="admin_memberlist.jsp?pg=<%=fromPage-1 %>">◀</a>]
					<%
					 }else{
					%>
					[<span style="color:gray">◀◀</span>]
					[<span style="color:gray">◀</span>]
					<%
					 }
					%>
					<%
					  for(int i = fromPage; i<= toPage; i++){
						  if(i == pg){
					%>
					      [<%=i %>]
					<%
						  }else{
					%>
					          [<a href="admin_memberlist.jsp?pg=<%=i %>"><%=i %></a>]
					<%
						  }
					  }
					%>    
					<%
						if(toPage < allPage){
					%>      
					      [<a href="admin_memberlist.jsp?pg=<%=toPage+1 %>">▶</a>]
					      [<a href="admin_memberlist.jsp?pg=<%=allPage %>">▶▶</a>]
					 <%
						  }else{
					 %>     
					 	   [<span style="color:gray">▶</span>]
					 	   [<span style="color:gray">▶▶</span>]
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