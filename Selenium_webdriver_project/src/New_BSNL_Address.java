import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class New_BSNL_Address {

	public static void main(String[] args) throws InterruptedException {

		String basepath = "/home/ganesh/Desktop/Input/";
		String cityName = "PUDUKKOTTAI";

		if (args[0] != null) {
			basepath = args[0];
		}
		if (args[1] != null) {
			cityName = args[1];
		}

		Thread4Digit b = new Thread4Digit(basepath, cityName);
		Thread4Digit b1 = new Thread4Digit(basepath, cityName);
		Thread4Digit b2 = new Thread4Digit(basepath, cityName);
		Thread4Digit b3 = new Thread4Digit(basepath, cityName);
		Thread4Digit b4 = new Thread4Digit(basepath, cityName);
		Thread4Digit b5 = new Thread4Digit(basepath, cityName);
		Thread4Digit b6 = new Thread4Digit(basepath, cityName);
		Thread4Digit b7 = new Thread4Digit(basepath, cityName);

		Thread th = new Thread(b);
		Thread th1 = new Thread(b1);
		Thread th2 = new Thread(b2);
		Thread th3 = new Thread(b3);
		Thread th4 = new Thread(b4);
		Thread th5 = new Thread(b5);
		Thread th6 = new Thread(b6);
		Thread th7 = new Thread(b7);

		th.start();
		Thread.sleep(2000);
		th1.start();
		Thread.sleep(2000);
		th2.start();
		Thread.sleep(2000);
		th3.start();
		Thread.sleep(2000);
		th4.start();
		Thread.sleep(2000);
		th5.start();
		Thread.sleep(2000);
		th6.start();
		Thread.sleep(2000);
		th7.start();

	}

}

class Thread4Digit implements Runnable {
	static Logger logger = Logger.getLogger("");
	public HtmlUnitDriver driver;
	public String URL;
	public StringBuffer errors;
	static long l = 0;
	String basepath = null;
	String cityName = null;

	public Thread4Digit(String path, String city) {
		this.basepath = path;
		this.cityName = city;
	}

	public void testSetupEnvironment() throws InterruptedException {
		driver = new HtmlUnitDriver(true);
		URL = "http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";
	}

	public void run() {
		logger.setLevel(Level.OFF);

		String output = null;
		String phone = null;
		File fin = new File(basepath + "/Input.txt");
		try {
			testSetupEnvironment();
			System.out.println("Completed Setup");
			RandomAccessFile rfa = new RandomAccessFile(fin, "rw");
			long lenght = rfa.length();

			do {
				phone = getm(rfa);
				if (phone != null && phone.length() > 0) {
					System.out.println("Number =" + phone);
					output = getPhoneNumbers(phone, cityName);
					System.out.println("Completed getPhoneNumbers");
					if (output != null) {
						writeOutput(basepath, output, phone);
					}
					output = null;
					phone = null;
					System.gc();
				}
			} while (l < lenght);

		} catch (Exception e) {
			writeNotOutput(basepath, phone, phone);
			e.printStackTrace();
		} finally {
			if (output != null) {
				writeOutput(basepath, output, phone);
				testTearDown();
				output = null;
			}
			System.gc();
		}

		testTearDown();

	}

	public synchronized String getPhoneNumbers(String phoneNumber,
			String cityName) throws InterruptedException {

		StringBuffer sb = new StringBuffer();

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
			Thread.sleep(4000);
			System.out.println("Wakeup from sleep");
			WebElement searchResultsCount = driver.findElement(By
					.xpath("//*[@id='contentSrchResult']/div[1]/div[1]/span"));
			WebElement searchResultsPageCount = driver.findElement(By
					.xpath("//*[@id='second']/span"));
			WebElement firstButton = driver.findElement(By
					.id("j_id10:FIRSTPGLink"));
			WebElement nextButton = driver.findElement(By
					.id("j_id10:PGDOWNLink"));
			System.out.println("nextButton.isEnabled() --> "
					+ nextButton.isEnabled());

			String strPageCount = searchResultsPageCount.getText();
			String[] splitStr = strPageCount.split("of");
			System.out.println("First -- " + splitStr[0].trim()
					+ "\n Second -- " + splitStr[1].trim());
			String totPageCount = splitStr[1].trim();

			Assert.assertTrue(firstButton.isDisplayed());
			System.out.println("Total Count" + searchResultsCount.getText());
			System.out.println("Total Page Count"
					+ searchResultsPageCount.getText());
			System.out.println("Is First Button displayed"
					+ firstButton.isDisplayed());

			Integer countPage;
			countPage = Integer.valueOf(totPageCount);

			System.out.println("Cout page ---- " + countPage);
			for (int k = 0; k < countPage; k++) {
				System.out.println("--------------- Start Record " + k
						+ " ----------------");

				WebElement table = driver.findElement(By.id("second:myTab"));
				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {

					List<WebElement> cell = row.findElements(By.tagName("td"));

					for (WebElement cellValue : cell) {
						sb.append(cellValue.getText());
						sb.append("\t");
					}
					sb.append("\n");
				}
				System.out.println("--------------- end of " + k
						+ " Record ----------------");
				nextButton.click();
				Thread.sleep(2000);

			}

		} catch (RuntimeException e) {
			writeNotOutput(basepath, phoneNumber, phoneNumber);
			e.printStackTrace();
		}

		return sb.toString();

	}

	public synchronized void testTearDown() {
		driver.close();
		driver.quit();
		System.out.println("TearDown");

	}

	private synchronized void writeOutput(String basepath, String output,
			String content) {

		try {
			File fout = null;
			int i = -1;
			do {
				i++;
				fout = new File(basepath + "output_" + content + "_" + i
						+ ".txt");
			} while (fout.exists());

			FileWriter fw = new FileWriter(fout);
			fw.write(output);
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private synchronized void writeNotOutput(String basepath, String output,
			String content) {

		try {
			File fout = null;
			int i = -1;
			do {
				i++;
				fout = new File(basepath + "NotFound_" + content + "_" + i
						+ ".txt");
			} while (fout.exists());

			FileWriter fw = new FileWriter(fout);
			fw.write(output);
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	synchronized String getm(RandomAccessFile rfa) {
		String tmp = null;
		try {
			rfa.seek(l);
			tmp = rfa.readLine();
			l = rfa.getFilePointer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp;
	}
}
