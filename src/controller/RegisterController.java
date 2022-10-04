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

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher fd = request.getRequestDispatcher("/register.jsp");
		fd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utf8Util.setUtf8AndContentType(request, response);
		StaffDAO obj = new StaffDAO();
		String maDN = request.getParameter("maDN");
		if ("".equals(maDN)) {
			String message = "Mời nhập mã đăng nhập! ";
			request.setAttribute("message", message);
			RequestDispatcher fd = request.getRequestDispatcher("/register.jsp");
			fd.forward(request, response);
			return;
		} else {
			Staff check = obj.checkExist(maDN);
			if (check == null) {
				String message = "Mã nhân viên này không tồn tại! ";
				request.setAttribute("message", message);
				RequestDispatcher fd = request.getRequestDispatcher("/register.jsp");
				fd.forward(request, response);
				return;
			} else if (null != check.getMatKhau()) {
				String message = "Mã nhân viên này đã tồn tại! ";
				request.setAttribute("message", message);
				RequestDispatcher fd = request.getRequestDispatcher("/register.jsp");
				fd.forward(request, response);
				return;
			} else {
				request.setAttribute("maDN", check.getMa());
				RequestDispatcher fd = request.getRequestDispatcher("/create.jsp");
				fd.forward(request, response);
				return;
			}
		}
	}

}
