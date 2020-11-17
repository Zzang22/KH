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

	#aside{
		margin: 20px;
		position: fixed;
		right: 0px;
		top: 40%; 
	}
	#aside_img{
		width: 110px;
		height: 110px;
	}
	
    #chatForm {
        position: absolute;
        display: none;
        left: 60%;
        top: 20%;
    }

    #closeBtn {
        position: absolute;
        z-index:10;
        width: 40px;
        margin-top:-20px;
    }

    #chatIframe{
    	width: 500px;
    	height: 700px;
    }
</style>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
    function popChat() {
        $("#chatForm").css("display", "block");
        $("#chatForm").draggable();
    }

    function popClose() {
        $("#chatForm").css("display", "none");
    }
</script>


</head>
<body>

	<aside id="aside">
		<a href="javascript:popChat();">
			<img id="aside_img" alt="chat_img" src="resources/images/chat_img.png">			
		</a>
		
	</aside>
	
	
		<div id="chatForm">
		
			<div style="text-align:right;">
	            <a href="javascript:;" onClick="popClose();">
	                <img id="closeBtn" src="resources/images/close_img.png"/>
	            </a>
	        </div>
		
		
			<iframe id="chatIframe" src="ChatServlet?command=open_chat"></iframe>
			
		
	        
		</div>
	

</body>
</html>