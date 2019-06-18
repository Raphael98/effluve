package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

public class Session {
	private HttpServletRequest req;
	
	public Session(HttpServletRequest req) {
		this.req = req;
	}
	public boolean isValid() {
		HttpSession session = this.req.getSession();
		return !(session != null && session.getAttribute("user") == null);
	}
	
	public boolean isAdmin() {
		HttpSession session = this.req.getSession();
		return !(session != null && session.getAttribute("user") == null && (boolean) session.getAttribute("admin") == true);
	}
}
