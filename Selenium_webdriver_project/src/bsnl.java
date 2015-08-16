import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class bsnl {

	public static void main(String[] args) throws InterruptedException {

		String basepath = "/home/ganesh/Desktop/Input/";
		String cityName = "CHENNAI";

//		if (args[0] != null) {
//			basepath = args[0];
//		}
//		if (args[1] != null) {
//			cityName = args[1];
//		}

		multithread b = new multithread(basepath, cityName);
		multithread b1 = new multithread(basepath, cityName);
		multithread b2 = new multithread(basepath, cityName);
		multithread b3 = new multithread(basepath, cityName);
		multithread b4 = new multithread(basepath, cityName);
		multithread b5 = new multithread(basepath, cityName);
		multithread b6 = new multithread(basepath, cityName);
		multithread b7 = new multithread(basepath, cityName);
		multithread b8 = new multithread(basepath, cityName);
		multithread b9 = new multithread(basepath, cityName);
		multithread b10 = new multithread(basepath, cityName);
	
		multithread b11 = new multithread(basepath, cityName);
		multithread b12 = new multithread(basepath, cityName);
		multithread b13 = new multithread(basepath, cityName);
		multithread b14 = new multithread(basepath, cityName);
		multithread b15 = new multithread(basepath, cityName);
		multithread b16 = new multithread(basepath, cityName);
		multithread b17 = new multithread(basepath, cityName);
		multithread b18 = new multithread(basepath, cityName);
		multithread b19 = new multithread(basepath, cityName);
		multithread b20 = new multithread(basepath, cityName);

		Thread th = new Thread(b);
		Thread th1 = new Thread(b1);
		Thread th2 = new Thread(b2);
		Thread th3 = new Thread(b3);
		Thread th4 = new Thread(b4);
		Thread th5 = new Thread(b5);
		Thread th6 = new Thread(b6);
		Thread th7 = new Thread(b7);
		Thread th8 = new Thread(b8);
		Thread th9 = new Thread(b9);
		Thread th10 = new Thread(b10);
		
		
		
		Thread th11 = new Thread(b11);
		Thread th12 = new Thread(b12);
		Thread th13 = new Thread(b13);
		Thread th14 = new Thread(b14);
		Thread th15 = new Thread(b15);
		Thread th16 = new Thread(b16);
		Thread th17 = new Thread(b17);
		Thread th18 = new Thread(b18);
		Thread th19 = new Thread(b19);
		Thread th20 = new Thread(b20);

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
		Thread.sleep(2000);
		th8.start();
		Thread.sleep(2000);
		th9.start();
		Thread.sleep(2000);
		th10.start();
		
		Thread.sleep(2000);
		th11.start();
		Thread.sleep(2000);
		th12.start();
		Thread.sleep(2000);
		th13.start();
		Thread.sleep(2000);
		th14.start();
		Thread.sleep(2000);
		th15.start();
		Thread.sleep(2000);
		th16.start();
		Thread.sleep(2000);
		th17.start();
		Thread.sleep(2000);
		th18.start();
		Thread.sleep(2000);
		th19.start();
		Thread.sleep(2000);
		th20.start();
	}
}

class multithread implements Runnable {
	Logger logger = Logger.getLogger("");

	public HtmlUnitDriver driver;
	public String URL;
	public StringBuffer errors;
	static long l = 0;
	String basepath = null;
	String cityName = null;

	public multithread(String path, String city) {
		this.basepath = path;
		this.cityName = city;
	}

	public void setupEnvironment() throws InterruptedException {
		driver = new HtmlUnitDriver(true);
		URL = "http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";

	}

	@Override
	public void run() {
		logger.setLevel(Level.OFF);
		StringBuffer output = new StringBuffer();
		StringBuffer error = new StringBuffer();

		File fin = new File(basepath + "Input.txt");
		try {
			setupEnvironment();
			String phone = null;
			RandomAccessFile rfa = new RandomAccessFile(fin, "rw");
			long lenght = rfa.length();

			int i = 0;
			do {
				i++;
				phone = getm(rfa);
				if (phone != null && phone.length() > 0) {
					System.out.println("get details for = " + phone);
					String out = getPhoneNumbers(phone, cityName);
					if (out != null) {
						output.append(out);
					} else {
						error.append(phone + "\n");
					}
				}

				if (i % 500 == 0) {

					if (output.toString().length() > 0) {
						writeOutput(basepath, output.toString());
					}
					if (error.toString().length() > 0) {
						writeError(basepath, error.toString());
					}
					output = null;
					error = null;
					System.gc();
					output = new StringBuffer();
					error = new StringBuffer();
				}
			} while (l < lenght);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (output.toString().length() > 0) {
				writeOutput(basepath, output.toString());
			}
			if (error.toString().length() > 0) {
				writeError(basepath, error.toString());
			}
			output = null;
			error = null;
			testTearDown();
			System.gc();
			System.out.println("TearDown");
		}

	}

	synchronized String getPhoneNumbers(String phoneNumber, String cityName)
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

			 List<WebElement> cell = allRows.get(1).findElements(By.tagName("td"));

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

	synchronized void testTearDown() {
		driver.close();
		driver.quit();
		// System.out.println(new Date());
	}

	synchronized String getAddresss(WebElement table) {

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

	synchronized void writeOutput(String basepath, String output) {

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

	synchronized void writeError(String basepath, String error) {

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
