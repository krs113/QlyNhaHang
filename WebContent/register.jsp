<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="<%=request.getContextPath()%>/resource/css/mainStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/register" class="content">
		<h2>Tạo tài khoản mới</h2>
			<input type="text" placeholder="Mã đăng nhập" name="maDN">
			
			<input type="submit" value="Tiếp theo" class="btn">
			
			<br>
			<a href="<%=request.getContextPath()%>/login" class="return-btn">Trở lại</a>
			
			<%
			if (request.getAttribute("message") != null) {
				String message = (String) request.getAttribute("message");
				out.print("<p style='color:red;'>" + message + "</p><br>");
			}
			%>
	</form>	
</body>
</html>