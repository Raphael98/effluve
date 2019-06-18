package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

public class Session {
	
	public static boolean isValid(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return !(session != null && session.getAttribute("user") == null);
	}
}
