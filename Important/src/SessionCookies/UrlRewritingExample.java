package SessionCookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UrlRewritingExample extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

		HttpSession sess = request.getSession();

		if (sess.isNew()) {
			//if cookies is disabled then session will be new for all request; obviously it will be new for very first request !!!
			//if its is new then we can enable response.encodeURL for URLREWIRTEING
			System.out.println("Heelo welocome a its new Sesssiommmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		}

		String t = (String) sess.getAttribute("token");
		System.out.println("\n\n\n " + t);
		sess.setAttribute("token", "authValidate");

		String contextPath = request.getContextPath();
		String encodedUrl = response.encodeURL(contextPath
				+ "/UrlRewritingExample.jsp");
		String Url = (contextPath + "/UrlRewritingExample.jsp");
		System.out.println("sess.getId();       " + sess.getId());

		out.println("<html>");
		out.println("<head>");
		out.println("<title>URL Rewriter</title>");
		out.println("</head>");
		out.println("<body><center>");
		out.println("<h2>URL rewriting Example</h2>");
		out.println("For welcome page - <a href=\"" + Url
				+ "\"> Click Here</a>.");
		out.println("</center></body>");
		out.println("</html>");

		System.out.println("<a href=\"" + Url + "\"> Click Here</a>.");

	}

}
