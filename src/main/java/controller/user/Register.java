package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

@WebServlet(urlPatterns = {"/userRegister"})
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User(req.getParameter("email"),req.getParameter("name"), req.getParameter("password"), req.getParameter("cep"),req.getParameter("number"));
		new UserDAO().add(user);
		RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatch.forward(req, resp);
	}
}
