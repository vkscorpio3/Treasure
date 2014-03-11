package SessionCookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class getSessionUsingJsessionID
 * 
 * How can i load Java HttpSession from JSESSIONID?
 */

public class getSessionUsingJsessionID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSessionUsingJsessionID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String JsessionId=request.getParameter("JsessionId");
		java.io.PrintWriter out = response.getWriter();
		HttpSession sessionObj=HttpSessionCollector.find(JsessionId);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>URL Rewriter</title>");
		out.println("</head>");
		out.println("<body><center>");
		out.println("<h2>URL rewriting Example</h2>");
		
		
		if(sessionObj !=null){
			System.out.println(sessionObj.getAttribute("token"));
			//token attribute is setting in UrlRewritingExample.java
			out.println("Given JseesionId ="+JsessionId+" will get a session Obj and its  attribute of 'Token' value =="+sessionObj.getAttribute("token")); 									
		}else{
			out.println("No session Obj is available for given JsessionId= " +JsessionId);
		}
		
		out.println("</center></body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
