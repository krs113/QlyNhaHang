package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffDAO xuLy = new StaffDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		int result = xuLy.deleteNV(id);
		if (result == 1) {
			String message = "X�a th�nh c�ng!!! ";
			request.setAttribute("message", message);
			response.sendRedirect(request.getContextPath()+"/quanli");
		}
	}

}
