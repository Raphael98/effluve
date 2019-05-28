package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;

@WebServlet("/deleteProduct")
public class Delete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		new ProductDAO().delete(id);
		req.setAttribute("deleted", true);
		req.getRequestDispatcher("WEB-INF/jsp/product/list-delete.jsp").forward(req, resp);
	}
}
