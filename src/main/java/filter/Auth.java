package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.user.Session;

@WebFilter(asyncSupported=true, servletNames = {"productManager","createProduct","createBrand", 
		"brandManager", "updateBrand", "createProduct", "deleteProduct", "single", "updateProduct"})
public class Auth implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(!Session.isValid(req)){
			req.setAttribute("failed", true);
			req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, res);
		}else {
			chain.doFilter(request, response);			
		}
	}
	


}
