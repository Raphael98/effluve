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

@WebFilter(asyncSupported=true, servletNames = {"updateBrand", "createProduct", "deleteProduct", "updateProduct"})
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
		Session session = new Session(req);
		if(!session.isValid()){
			req.setAttribute("failed", true);
			req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, res);
		}else {
			chain.doFilter(request, response);			
		}
	}
	


}
