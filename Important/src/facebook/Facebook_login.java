package facebook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Facebook_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Facebook_login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		String sessionId = session.getId();
		String appId = "781664071859098";
		String redirectUrl = "http://localhost:8080/Important/SecurityServlet";
		String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
				+ appId + "&redirect_uri=" + redirectUrl
				+ "&scope=email,user_birthday&state=" + sessionId;
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		response.sendRedirect(returnValue);
	}

}
