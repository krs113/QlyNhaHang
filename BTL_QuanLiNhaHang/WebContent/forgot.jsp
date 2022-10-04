<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link href="<%=request.getContextPath()%>/resource/css/mainStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/forgot" class="content">
		<h2>Quên mật khẩu</h2>
		
		<input type="text" placeholder="Số điện thoại" name="sdt">
		
		<input type="submit" value="Xác nhận" class="btn">
		
		<br>
		<a href="<%=request.getContextPath()%>/login" class="return-btn" > Trở lại</a>
		
		<%
		if (request.getAttribute("message") != null){
			String message = (String) request.getAttribute("message");
			out.print("<p style='color:red;'>" + message +"</p><br>");
				}
		%>
	</form>
</body>
</html>