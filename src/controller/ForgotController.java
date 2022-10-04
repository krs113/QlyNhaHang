package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;
import model.Staff;

public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ForgotController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher fd = request.getRequestDispatcher("/forgot.jsp");
		fd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffDAO obj = new StaffDAO();
		String phone = request.getParameter("sdt");
		if ("".equals(phone)) {
			String message = "Mời nhập số điện thoại đã đăng kí !";
			request.setAttribute("message", message);
			RequestDispatcher fd = request.getRequestDispatcher("/forgot.jsp");
			fd.forward(request, response);
			return;
		} else {
			Staff check = obj.checkExistByPhone(phone);
			if (check == null) {
				String message = "Nhân viên này không tồn tại !";
				request.setAttribute("message", message);
				RequestDispatcher fd = request.getRequestDispatcher("/forgot.jsp");
				fd.forward(request, response);
				return;
			} else {
				request.setAttribute("phone", phone);
				RequestDispatcher fd = request.getRequestDispatcher("/forgotPassword.jsp");
				fd.forward(request, response);
			}
		}
	}
}
