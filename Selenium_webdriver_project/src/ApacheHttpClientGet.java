import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApacheHttpClientGet {

	private HttpClient httpClient;

	public static void main(String[] args) {
		try {

			ApacheHttpClientGet client = new ApacheHttpClientGet();

			String json = client
					.getOutput("http://api.espn.com/v1/now/?apikey=txe3cw2jb4vu54xcp2j597yj");
			JSONParser parser = new JSONParser();
			JSONObject out = (JSONObject) parser.parse(json);
			System.out.println(out.get("timestamp"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String getOutput(String url) {
		String json = null;
		try {
			httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", "application/json");
			
			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output = null;
			while ((output = br.readLine()) != null) {
				json = output;
				System.out.println("output   "+output);
			}

			System.out.println("|||||||||"+output);
			System.out.println(json);
			httpClient.getConnectionManager().shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}

}
