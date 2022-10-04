<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="<%=request.getContextPath()%>/resource/css/creStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%
		String maDN = (String) request.getAttribute("maDN");
		if (maDN != null) {
		%>	
		<form method="post" action="<%=request.getContextPath()%>/create" class="content">
			<h2>Tạo tài khoản mới</h2>
			<input type="text" placeholder="Họ và tên" name="hoTen" required>
			<input type="text" placeholder="Giới tính" name="gioiTinh" required>
			<input type="text" placeholder="Số điện thoại" name="sdt" required>
			<input type="date" placeholder="Ngày sinh" name="ngáyinh" required>
			<input type="hidden" name="maDN" value="<%=maDN%>">
			<input type="password" placeholder="Mật khẩu" name="matKhau" required>
			<input type="submit" value="Đăng kí" class="btn">
			<br>
			<br>
			<a href="<%=request.getContextPath()%>/register" class="return-btn">Trở lại</a>
			<%
			if (request.getAttribute("message") != null) {
				String message = (String) request.getAttribute("message");
					out.print("<p style='color:red;'>" + message +"</p><br><br>");
				}
			%>
		</form>	
		<%}%>
</body>
</html>