<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/loginStyle.css">
    <link rel="icon" href="<%=request.getContextPath()%>/resource/img/4e24f523182e09376bfe8424d556610a.png" type="image/x-icon" />
    <title>Login</title>
</head>
<body>
    <div id="main">
        <div id="header">
            <img src="./resource/img/logo.png" alt="logo" class="header-logo">
            <h2 style="font-size: 32px;">Chào mừng đến với St Rooftop</h2>
        </div>

        <div id="content">
            <div class="row content-section">
                <div class="col login-form">
                    <form method="post" action="<%=request.getContextPath()%>/login">
                        <h3 class="row content-heading" >Đăng nhập bằng tài khoản của bạn</h3>
                        <div class="row mt16">
                            <label for="" class="content-label">
                                Mã đăng nhập
                            </label>
                            <input type="text" required class="content-form" name="username">
                        </div>
                        <div class="row mt16">
                            <label for="" class="content-label">
                                Mật khẩu
                            </label>
                            <input type="password" required class="content-form" name="password">
                        </div>

                        <input type="submit" class="row content-btn" value="ĐĂNG NHẬP">
<br>
						<%
						if (request.getAttribute("message") != null) {
							String message = (String) request.getAttribute("message");
							out.print("<p style='color:red;'>" + message +"</p><br><br>");
							}
						%> 
						
						<a href="<%=request.getContextPath()%>/forgot" class="content-link">
						| Quên mật khẩu</a>           			
                    </form>
                </div>
                <div class="col join-form">
                	<form method="get" action="<%=request.getContextPath()%>/register">
                    	<h3 class="row content-heading" >Tham gia St Rooftop</h3>
                    	<img class="content-view" src="./resource/img/restaurant.jpg" alt="Nhà hàng">
                    	<button class="row content-btn">Kích hoạt tài khoản</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>