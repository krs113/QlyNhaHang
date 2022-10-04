<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Password</title>
<link href="<%=request.getContextPath()%>/resource/css/mainStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String phone = (String) request.getAttribute("phone");
		if ( phone != null) {
	%>
	<form method="post" action="<%=request.getContextPath()%>/forgotPass" class="content">
		<h2>Tạo mật khẩu mới</h2>
		<input type="password" placeholder="Mời nhật mật khẩu mới" name="newPass" required>
		<input type="hidden" name="sdt" value="<%=phone%>">
		<br>
		<%
		if (request.getAttribute("message") != null) {
			String message = (String) request.getAttribute("message");
			out.print("<p style='color:red;'>" + message +"</p><br>");
			}
		%>
		<input type="submit" value="Xác nhận" class="btn">
		<br>
		<a href="<%=request.getContextPath()%>/forgot" class="return-btn"> Trở lại</a>
	</form>
		<%} %>
</body>
</html>