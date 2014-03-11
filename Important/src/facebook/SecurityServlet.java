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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecurityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String faceCode = request.getParameter("code");
		String state = request.getParameter("state");
		String accessToken = getFacebookAccessToken(faceCode);
		System.out.println("Access Code ===" + accessToken);
		String email = getUserMailAddressFromJsonResponse(accessToken,
				httpSession);
		System.out.println("Email ===" + email);
		String sessionID = httpSession.getId();
		if (state.equals(sessionID)) {
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

				token = convertReponseToString(response);
				token = token.replaceAll("access_token=", "");
				token = token.replaceAll("&expires=5180403", "");

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

				String output = convertReponseToString(response);

				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(output);

				String facebookId = (String) json.get("id");
				String firstName = (String) json.get("first_name");
				String lastName = (String) json.get("last_name");
				email = (String) json.get("email");
				// put user data in session
				httpSession.setAttribute("FACEBOOK_USER", firstName + " "
						+ lastName + ", facebookId:" + facebookId);

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

	private String convertReponseToString(HttpResponse response) {
		String output = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String tmp = null;
			while ((tmp = br.readLine()) != null) {
				output = tmp;
				System.out.println("output   " + output);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return output;
	}

}
