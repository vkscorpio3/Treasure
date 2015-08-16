import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class web_driver_class {

	static Logger logger = Logger.getLogger("");
	static WebDriver driver = new HtmlUnitDriver();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		logger.setLevel(Level.OFF);
		StringBuffer output = new StringBuffer();
		StringBuffer error = new StringBuffer();
		String url = null;
		String data = null;

		String basepath = args[0];

		File fin = new File(basepath + "input.txt");
		try {
			FileReader fr;

			fr = new FileReader(fin);

			BufferedReader br = new BufferedReader(fr);

			do {
				url = br.readLine();
				data = getDetails(driver, url);

				if (data == null) {
					error.append(url);
					error.append("\n");

				} else {
					output.append(data);
				}

			} while (url != null);

			br.close();
			fr.close();

		} catch (Exception e) {
			// e.printStackTrace();
			System.out
					.println("****************File Not Found please Provide proper file path **********************");

		}
		writeError(basepath, error.toString());
		writeOutput(basepath, output.toString());

		driver.close();
		System.out.println("Completed the Conversion !!!!!!");
	}

	private static String getDetails(WebDriver driver, String link) {
			System.out.println(link);		
		try {
			driver.get(link);
			String phoneno = driver.getTitle();
			String address = driver.findElement(By.className("address-tags"))
					.getText();
			address = address.replaceAll("Follow @phunwa", "");
			address = address.replaceAll("(.*)Other Numbers:(.*)", "");
			address = address.replaceAll("(.*)Location:(.*)", "");
			address = address.replaceAll("\n", "\t");

			address = address.trim();
			StringBuffer out = new StringBuffer();
			out.append("Phone: " + phoneno + "\t");
			out.append(address);
			out.append("\n");
			return out.toString();

		} catch (Exception e) {
			return null;
		}

	}

	private static void writeOutput(String basepath, String output) {

		try {
			File fout = new File(basepath + "output.txt");
			FileWriter fw = new FileWriter(fout);
			fw.write(output);
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void writeError(String basepath, String error) {

		try {
			File ferr = new File(basepath + "NotFound.txt");

			FileWriter fwerr = new FileWriter(ferr);
			fwerr.write(error);
			fwerr.flush();
			fwerr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
