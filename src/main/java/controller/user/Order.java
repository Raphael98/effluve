package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

@WebServlet(urlPatterns = {"/orders"})
public class Order extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/my-orders.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		entity.Order order = new entity.Order(req.getParameter("user"), req.getParameter("product"));
		new OrderDAO().add(order);
		req.getRequestDispatcher("WEB-INF/jsp/my-orders.jsp").forward(req, resp);
	}
}
