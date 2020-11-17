<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/*'확인'버튼 디자인*/
#idcheck_button{
	width: 165px;
	height: 25px;	
	border: none;
	background: #efefef;
}

/* '아이디 중복확인', "아이디 사용하기" : "중복된 아이디 입니다." 제목 중앙정렬 */
.idcheck_div{
	text-align: center;
}

/* table 중앙정렬*/
#idcheck_table{
	display: block;
	width: 200px;
	position: fixed;
   margin: 0 auto;
   left: 0;
   right: 0;

}



</style>
<script type="text/javascript">

	onload=function(){
		var member_id = opener.document.getElementsByName("member_id")[0].value;
		document.getElementsByName("member_id")[0].value=member_id;
	}
	
	function idConfirm(bool){
		if(bool == "true"){
			opener.document.getElementsByName("member_id")[0].title="y";
			opener.document.getElementsByName("member_pw")[0].focus();
		}else{
			opener.document.getElementsByName("member_id")[0].focus();
		}
		self.close();
	}

</script>
</head>
<%
	String idnotused = request.getParameter("idnotused");
%>
<body>
	<div class="idcheck_div">
	<h3>아이디 중복확인</h3>
	<hr>
	<table id="idcheck_table">
		<col width="200px">
		<tr>
			<td align="center"><input type="text" name="member_id" readonly="readonly"/></td>
		</tr>
		<tr>
			<th align="center"><%=idnotused.equals("true")? "사용 가능합니다." : "중복된 아이디 입니다." %></th>
		</tr>
		<tr>
			<td align="center">
				<input type="button" value="확인"  id="idcheck_button" onclick="idConfirm('<%=idnotused %>');"/>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>