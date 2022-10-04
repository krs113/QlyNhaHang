package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;

public class NewPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewPassController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher fd = request.getRequestDispatcher("/forgotPassword.jsp");
		fd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffDAO xuLy = new StaffDAO();

		String sdt = request.getParameter("sdt");
		String matKhau = request.getParameter("newPass");

		if ("".equals(matKhau)) {
			request.setAttribute("sdt", sdt);
			String message = "Vui lòng nhập mật khẩu mới! ";
			request.setAttribute("message", message);
			RequestDispatcher fd = request.getRequestDispatcher("/forgotPassword.jsp");
			fd.forward(request, response);
			return;
		} else {

			int result = xuLy.updatePass(sdt, matKhau);
			if (result == 1) {
				String message = "Thay đổi mật khẩu thành công!!! ";
				request.setAttribute("message", message);
				System.out.println("Thành công!!!");
				RequestDispatcher fd = request.getRequestDispatcher("/login.jsp");
				fd.forward(request, response);
			
		}

	}
}
}
