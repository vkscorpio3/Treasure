import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bsnl_old {
	// public WebDriver driver;
	static Logger logger = Logger.getLogger("");

	public HtmlUnitDriver driver;
	public String URL;
	public StringBuffer errors;

	public void setupEnvironment() throws InterruptedException {
		driver = new HtmlUnitDriver(true);
		URL = "http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";

	}

	public static void main(String a[]) {
		logger.setLevel(Level.OFF);
		StringBuffer output = new StringBuffer();
		StringBuffer error = new StringBuffer();
		bsnl_old bt = new bsnl_old();

		String basepath = "/home/ganesh/Desktop/Input/";
		String cityName = "HYDERABAD - SECUNDRABAD";

//		if (a[0] != null) {
//			basepath = a[0];
//		}
//		if (a[1] != null) {
//			cityName = a[1];
//		}

		File fin = new File(basepath + "Input.txt");
		try {
			FileReader fr = new FileReader(fin);
			BufferedReader br = new BufferedReader(fr);
			String phone = null;
			bt.setupEnvironment();
			int i = 0;
			do {
				i++;
				phone = br.readLine();
				bt.setupEnvironment();

				if (phone != null && phone.length() > 0) {
					System.out.println("get details for = " + phone);
					String out = bt.getPhoneNumbers(phone, cityName);
					if (out != null) {
						output.append(out);
					} else {
						error.append(phone + "\n");
					}
				}

				if (i % 1 == 0) {

					if (output.toString().length() > 0) {
						bt.writeOutput(basepath, output.toString());
					}
					if (error.toString().length() > 0) {
						bt.writeError(basepath, error.toString());
					}
					output = null;
					error = null;
					System.gc();
					output = new StringBuffer();
					error = new StringBuffer();
				}
			} while (phone != null);

			br.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (output.toString().length() > 0) {
				bt.writeOutput(basepath, output.toString());
			}
			if (error.toString().length() > 0) {
				bt.writeError(basepath, error.toString());
			}
			output = null;
			error = null;
			bt.testTearDown();
			System.gc();
			System.out.println("TearDown");
		}

	}

	public String getPhoneNumbers(String phoneNumber, String cityName)
			throws InterruptedException {
		StringBuffer output = new StringBuffer();
		driver.get(URL);
		Thread.sleep(3000);
		WebElement phone = driver.findElement(By.id("revPhone:firstField"));
		WebElement city = driver.findElement(By.id("revPhone:city"));
		WebElement search = driver.findElement(By.id("revPhone:search"));

		try {
			phone.clear();
			phone.sendKeys(phoneNumber);
			city.clear();
			city.sendKeys(cityName);
			search.click();
			Thread.sleep(3000);

			WebElement table = null;
			List<WebElement> allRows = null;

			try {
				table = driver.findElement(By.id("second:myTab"));
			} catch (Exception e) {
				return null;
			}

			allRows = table.findElements(By.tagName("tr"));
			List<WebElement> cell = null;

			cell = allRows.get(1).findElements(By.tagName("td"));

			if (cell.size() > 0) {
				WebElement link = cell.get(0).findElement(
						By.id("second:myTab:0:tab1"));
				link.click();
				Thread.sleep(1000);
				output.append(getAddresss(driver.findElement(By
						.tagName("table"))));
				output.append("\n");
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	public void testTearDown() {
		driver.close();
		driver.quit();
		System.out.println(new Date());
	}

	public String getAddresss(WebElement table) {

		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		StringBuffer sb = new StringBuffer();
		List<WebElement> cell = null;
		for (WebElement tds : allRows) {
			cell = tds.findElements(By.tagName("td"));
			sb.append(cell.get(1).getText());
			sb.append("\t");
		}
		return sb.toString();
	}

	private void writeOutput(String basepath, String output) {

		try {
			File fout = null;
			int i = -1;
			do {
				i++;
				fout = new File(basepath + "output" + i + ".txt");
			} while (fout.exists());

			FileWriter fw = new FileWriter(fout);
			fw.write(output);
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void writeError(String basepath, String error) {

		try {
			File ferr = null;

			int i = -1;
			do {
				i++;
				ferr = new File(basepath + "NotFound" + i + ".txt");
			} while (ferr.exists());

			FileWriter fwerr = new FileWriter(ferr);
			fwerr.write(error);
			fwerr.flush();
			fwerr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
