package facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.omg.CORBA.RepositoryIdHelper;

/**
 * Servlet implementation class SecurityServlet
 */
public class SecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecurityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String faceCode = request.getParameter("code");
		String state = request.getParameter("state");
		String accessToken = getFacebookAccessToken(faceCode);
		System.out.println(accessToken);
		String email = getUserMailAddressFromJsonResponse(accessToken,
				httpSession);
		String sessionID = httpSession.getId();
		if (state.equals(sessionID)) {
			// do some specific user data operation like saving to DB or
			// login user
			System.out.println("Stroing into DB");
		} else {
			System.err.println("CSRF protection validation");
		}

		response.sendRedirect("getFacebookOutput.jsp");
	}

	private String getFacebookAccessToken(String faceCode) {
		String token = null;
		if (faceCode != null && !"".equals(faceCode)) {
			String appId = "781664071859098";
			String redirectUrl = "http://localhost:8080/Important/SecurityServlet";
			String faceAppSecret = "cc507cbc2f48d66baecefdaff8e02e90";
			String newUrl = "https://graph.facebook.com/oauth/access_token?client_id="
					+ appId
					+ "&redirect_uri="
					+ redirectUrl
					+ "&client_secret=" + faceAppSecret + "&code=" + faceCode;
			DefaultHttpClient httpclient = new DefaultHttpClient();

			try {
				HttpGet httpget = new HttpGet(newUrl);
				httpget.addHeader("accept", "application/json");
				HttpResponse response = httpclient.execute(httpget);
				System.out.println("access code " + response);

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));

				String output = null;
				while ((output = br.readLine()) != null) {
					token=output;
					System.out.println("output   " + output);
				}
				
				token =token.replaceAll("access_token=", "");
				token =token.replaceAll("&expires=5180403", "");

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				httpclient.getConnectionManager().shutdown();
			}
		}
		return token;
	}

	private String getUserMailAddressFromJsonResponse(String accessToken,
			HttpSession httpSession) {
		String email = null;
		HttpClient httpclient = new DefaultHttpClient();
		try {
			if (accessToken != null && !"".equals(accessToken)) {
				String newUrl = "https://graph.facebook.com/me?access_token="
						+ accessToken;
				httpclient = new DefaultHttpClient();
				HttpGet httpget = new HttpGet(newUrl);
				System.out.println("Get info from face --> executing request: "
						+ httpget.getURI());

				HttpResponse response = httpclient.execute(httpget);
				System.out.println(response);

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));

				String output = null;

				while ((output = br.readLine()) != null) {
					
					System.out.println("output   " + output);
				}
				
			


				// JSONParser parser = new JSONParser();
				// JSONObject json = (JSONObject) parser.parse(responseBody);
				// // JSONObject json =
				// (JSONObject)JSONSerializer.toJSON(responseBody);
				// String facebookId = json.get("id");
				// String firstName = json.getString("first_name");
				// String lastName = json.getString("last_name");
				// email= json.getString("email");
				// //put user data in session
				// httpSession.setAttribute("FACEBOOK_USER", firstName+" "
				// +lastName+", facebookId:" + facebookId);
				//
			} else {
				System.err.println("Token for facebook is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return email;
	}

}
