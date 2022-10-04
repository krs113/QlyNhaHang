<%@page import="model.Staff"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wellcome</title>
</head>
<body>
<%
	Staff obj = (Staff) session.getAttribute("account");
	if (obj != null) {
%>
<h2>Wellcome <%=obj.getHoTen() %>!</h2>
        <a href="<%=request.getContextPath()%>/logout">Đăng xuất</a>
        <%
        	}
		%>
</body>
</html>