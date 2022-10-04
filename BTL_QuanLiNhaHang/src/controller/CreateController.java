package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;
import dao.StaffDAO;
import utils.Utf8Util;

public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher fd = request.getRequestDispatcher("/create.jsp");
		fd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utf8Util.setUtf8AndContentType(request, response);
		StaffDAO xuLy = new StaffDAO();
		int id = 0;
		String hoTen = request.getParameter("hoTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String sdt = request.getParameter("sdt");
		String ngaySinh = request.getParameter("ngaySinh");
		String matKhau = request.getParameter("matKhau");
		String ma = request.getParameter("maDN");

		if ("".equals(hoTen) || "".equals(gioiTinh) || "".equals(sdt) || "".equals(ngaySinh) || "".equals(matKhau)) {
			String message = "Vui lòng nhập đầy đủ! ";
			request.setAttribute("message", message);
			RequestDispatcher fd = request.getRequestDispatcher("/create.jsp");
			fd.forward(request, response);
			return;
		} else {
			Staff checkPhone = xuLy.checkExistByPhone(sdt);
			if (checkPhone == null) {
				Staff obj = new Staff(id, hoTen, gioiTinh, sdt, ngaySinh, ma, matKhau);
				int result = xuLy.updateInf(obj);
				if (result == 1) {
					String message = "Tạo tài khoản thành công!!! ";
					request.setAttribute("message", message);
					RequestDispatcher fd = request.getRequestDispatcher("/login.jsp");
					fd.forward(request, response);
					return;
				}
			} else {
				String message = "Tạo tài khoản thất bại!!!! ";
				request.setAttribute("message", message);
				RequestDispatcher fd = request.getRequestDispatcher("/login.jsp");
				fd.forward(request, response);
				return;
			}

		}
	}

}
