package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

@WebServlet("/userRegister")
public class UserRegister extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		new UserDAO().add(req.getParameter("email"),req.getParameter("name"), req.getParameter("password"));
		RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatch.forward(req, resp);
	}
}
