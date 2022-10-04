package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Staff;
import dao.StaffDAO;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher fd = request.getRequestDispatcher("/login.jsp");
		fd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffDAO obj = new StaffDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("".equals(username) || "".equals(password)) {
			RequestDispatcher fd = request.getRequestDispatcher("/login.jsp");
			fd.forward(request, response);
			return;
		} else {
			Staff check = obj.checkLogin(username, password);
			int checkValid = checkValid(check);
			HttpSession session = request.getSession();
			switch (checkValid) {
			case 1: {
				session.setAttribute("account", check);
				response.sendRedirect(request.getContextPath()+"/quanli");
				return;
			}
			case 2: {
				session.setAttribute("account", check);
				RequestDispatcher fd = request.getRequestDispatcher("/nhanvien.jsp");
				fd.forward(request, response);
				return;
			}
			case 0: {
				String message = "User hoặc Password sai!!! ";
				request.setAttribute("message", message);
				RequestDispatcher fd = request.getRequestDispatcher("/login.jsp");
				fd.forward(request, response);
				return;
			}

			}
		}

	}

	private int checkValid(Staff obj) {
		if (obj != null) {
			if ("NV".equals(obj.getMa().substring(0, 2)) || "nv".equals(obj.getMa().substring(0, 2))) {
				return 2;
			} else if ("QL".equals(obj.getMa().substring(0, 2)) || "ql".equals(obj.getMa().substring(0, 2))) {
				return 1;
			}
		}
		return 0;
	}

}
