package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		User user = new User(email, req.getParameter("password"));
		User logged = new UserDAO().login(user);
		if(logged != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", logged.getFirstName());
			session.setAttribute("id", logged.getId());
			session.setAttribute("admin", logged.isAdmin());
			session.setMaxInactiveInterval(30*60);
			req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
		}else {
			req.setAttribute("failed", true);
			req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}
}
