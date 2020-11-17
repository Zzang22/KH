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
		var corp_businessno = opener.document.getElementsByName("corp_businessno")[0].value;
		document.getElementsByName("corp_businessno")[0].value=corp_businessno;
	}

	function BnoConfirm(bool){
		if(bool == "true"){
			opener.document.getElementsByName("corp_businessno")[0].title="v";
			opener.document.getElementsByName("corp_ceo_name")[0].focus();
		}else{
			opener.document.getElementsByName("corp_businessno")[0].focus();
		}
		self.close();
	}

</script>
</head>

<% String b_no_notused = request.getParameter("b_no_notused"); %>

<body>
	<div class="idcheck_div">
	<h3>사업자번호 중복확인</h3>
	<hr>
		<table id="idcheck_table">
			<col width="200px">
		<tr>
			<td align="center"><input type="text" name="corp_businessno" readonly="readonly"/></td>
		</tr>
		<tr>
			<th align="center"><%=b_no_notused.equals("true")? "사용 가능합니다." : "중복된 번호 입니다." %> </th>
		</tr>
		<tr>
			<td align="center">
				<input type="button" id="idcheck_button" value="확인" onclick="BnoConfirm('<%=b_no_notused %>');"/>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>



