<%@page import="model.Staff"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Quản lý | Nhà hàng St Rooftop</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resource/css/adminStyle.css"
	rel="stylesheet" />
<link 
	href="<%=request.getContextPath()%>/resource/img/4e24f523182e09376bfe8424d556610a.png" type="image/x-icon" 
	rel="icon" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<%
		Staff acc = (Staff) session.getAttribute("account");
	if (acc != null) {
	%>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3"
			href="<%=request.getContextPath()%>/webpage">St Rooftop</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
	<form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group">
                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."
                    aria-describedby="btnNavbarSearch" />
                <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i
                        class="fas fa-search"></i></button>
            </div>
        </form>

		<!-- Navbar-->
		<%
			Staff obj = (Staff) session.getAttribute("account");
		if (obj != null) {
		}
		%>
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i> Xin chào! <%=acc.getHoTen()%> </a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li>
						<hr class="dropdown-divider" />
					</li>
					<li><a class="dropdown-item"
						href="<%=request.getContextPath()%>/logout">Đăng xuất</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="<%=request.getContextPath()%>/quanli">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Quản lý nhân viên
						</a>

					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Quản lý
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Quản lý nhân viên</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/quanli">Dashboard</a></li>
						<li class="breadcrumb-item active">Quản lý nhân viên</li>
					</ol>

					<div class="card mb-4">
						<div class="card-header">

							

							<%
								if (request.getParameter("mgs") != null) {
								int message = Integer.parseInt(request.getParameter("mgs"));
								System.out.print(message);
							%>
								<%
									switch (message) {
								case 0:
								%>
								<div class="alert alert-danger">
								<strong>Thất bại!</strong>
								<%
									break;
								case 1:
								%>
								<div class="alert alert-success">
								<strong>Thêm thành công!</strong>
								<%
									break;
															case 2:
								%>
								<div class="alert alert-success">
								<strong>Sửa thành công!</strong>
								<%
									break;
															case 4:
								%>
								<div class="alert alert-danger">
								<strong>Mã đã tồn tại!</strong>
								<%
								break;
									}
								%>
							</div>
							<%
								}
							%>
							<button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#exampleModalAdd">
								Thêm mới</button>
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ID</th>
										<th>Họ Tên</th>
										<th>Giới tính</th>
										<th>Điện thoại</th>
										<th>Ngày sinh</th>
										<th>Mã đăng nhập</th>
										<th width="300">Thao tác</th>

									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID</th>
										<th>Họ Tên</th>
										<th>Giới tính</th>
										<th>Điện thoại</th>
										<th>Ngày sinh</th>
										<th>Mã đăng nhập</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
									<%
										List<Staff> listNV = (List<Staff>) request.getAttribute("listNV");
									if (listNV != null) {
										for (Staff nhanvien : listNV) {
									%>
									<tr>
										<td><%=nhanvien.getId()%></td>
										<td><%=nhanvien.getHoTen()%></td>
										<td><%=nhanvien.getGioiTinh()%></td>
										<td><%=nhanvien.getSdt()%></td>
										<td><%=nhanvien.getNgaySinh()%></td>
										<td><%=nhanvien.getMa()%></td>
										<td>

											<button type="button" class="btn btn-primary"
												data-bs-toggle="modal"
												data-bs-target="#exampleModal<%=nhanvien.getId()%>">Sửa</button>
											<button type="button" class="btn btn-danger"
														data-bs-toggle="modal"
														data-bs-target="#exampleModalDel<%=nhanvien.getId()%>">
														Xóa</button>
														 <!--Dele-->
													<div class="modal fade" id="exampleModalDel<%=nhanvien.getId()%>"
														tabindex="-1" aria-labelledby="exampleModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">Bạn
																		chắc chắn muốn xóa ?</h5>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>

																<div class="modal-body">
																	Nhân viên :
																	<%=nhanvien.getHoTen()%>
																	<form action="<%=request.getContextPath()%>/delete"	method="post">
																		<input type="hidden" name="id" value="<%=nhanvien.getId()%>">
																		<div class="modal-footer" style="margin-top: 20px">
																			<button style="width: 100px" type="button"
																				class="btn btn-secondary" data-bs-dismiss="modal">
																				Không</button>
																			<button style="width: 100px" type="submit"
																				class="btn btn-danger" name="deletenguoidung">
																				Có</button>

																		</div>

																	</form>

																</div>

															</div>
														</div>
													</div> <!--Dele-->


										</td>
									</tr>
									<!-- Modal Add-->
									<div class="modal fade" id="exampleModalAdd" tabindex="-1"
										aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Thêm
														mới</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													<form method="post"
														action="<%=request.getContextPath()%>/add">
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Họ
																tên:</label> <input type="text" class="form-control"
																id="category-film" name="hoTen">
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Giới
																tính:</label> <input type="text" class="form-control"
																id="category-film" name="gioiTinh">
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Số
																điện thoại:</label> <input type="text" class="form-control"
																id="category-film" name="sdt">
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Ngày
																sinh:</label> <input type="date" class="form-control"
																id="category-film" name="ngaySinh">
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Mã đăng nhập:</label>
															<input type="text" class="form-control"
																id="category-film" name="ma" required>
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">Đóng</button>
															<input type="submit" class="btn btn-primary" value="Lưu">
															</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
									<!-- Modal Add-->
									<!-- Modal Update-->
									<div class="modal fade" id="exampleModal<%=nhanvien.getId()%>"
										tabindex="-1" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Cập
														nhập</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													<form method="post"
														action="<%=request.getContextPath()%>/update">
														<div class="mb-3">
															<input type="hidden" class="form-control"
																id="category-film" name="id"
																value="<%=nhanvien.getId()%>">
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Họ
																tên:</label> <input type="text" class="form-control"
																id="category-film" name="hoTen"
																value="<%=nhanvien.getHoTen()%>" required>
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Giới
																tính:</label> <input type="text" class="form-control"
																id="category-film" name="gioiTinh"
																value="<%=nhanvien.getGioiTinh()%>" required>
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Số
																điện thoại:</label> <input type="text" class="form-control"
																id="category-film" name="sdt"
																value="<%=nhanvien.getSdt()%>" required>
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Ngày
																sinh:</label> <input type="date" class="form-control"
																id="category-film" name="ngaySinh"
																value="<%=nhanvien.getNgaySinh()%>" required>
														</div>
														<div class="mb-3">
															<label for="category-film" class="col-form-label">Mã đăng nhập:</label>
															<input type="text" class="form-control"
																id="category-film" name="ma"
																value="<%=nhanvien.getMa()%>" readonly>
														</div>
														<div class="mb-3">
															<input type="hidden" class="form-control"
																id="category-film" name="matKhau"
																value="<%=nhanvien.getMatKhau()%>" required>
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">Đóng</button>
															<input type="submit" class="btn btn-primary" value="Lưu">
															</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
									<!-- Modal Update-->
									<%
										}
									}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Nhà hàng St Rooftop</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resource/js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resource/js/datatables-simple-demo.js"></script>
	<%
		}
	%>
</body>

</html>