import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;


public class Bsnl_addr_full {
	

	public static void main(String[] args) throws InterruptedException {

		String basepath = "/home/ganesh/Desktop/Input/";
		String cityName = "CHENNAI";

		if (args[0] != null) {
			basepath = args[0];
		}
		if (args[1] != null) {
			cityName = args[1];
		}

		Thread4d b = new Thread4d(basepath, cityName);
		Thread4d b1 = new Thread4d(basepath, cityName);
		Thread4d b2 = new Thread4d(basepath, cityName);
		Thread4d b3 = new Thread4d(basepath, cityName);
		Thread4d b4 = new Thread4d(basepath, cityName);
		Thread4d b5 = new Thread4d(basepath, cityName);
		Thread4d b6 = new Thread4d(basepath, cityName);
		Thread4d b7 = new Thread4d(basepath, cityName);
		Thread4d b8 = new Thread4d(basepath, cityName);
		Thread4d b9= new Thread4d(basepath, cityName);
		Thread4d b10 = new Thread4d(basepath, cityName);
		Thread4d b11 = new Thread4d(basepath, cityName);

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
//		Thread.sleep(2000);
//		th8.start();
//		Thread.sleep(2000);
//		th9.start();
//		Thread.sleep(2000);
//		th10.start();
//		Thread.sleep(2000);
//		th11.start();

	}

}

class Thread4d implements Runnable {
	static Logger logger = Logger.getLogger("");
	public  Driver driver;
	public String URL;
	public StringBuffer errors;
	static long l = 0;
	String basepath = null;
	String cityName = null;

	public Thread4d(String path, String city) {
		this.basepath = path;
		this.cityName = city;
	}

	public void testSetupEnvironment() throws InterruptedException {
		driver = new Driver(true);
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
			String cityName){

		StringBuffer sb = new StringBuffer();
		try {
		driver.get(URL);
		//Thread.sleep(3200);
		WebElement phone = getWebElement("revPhone:firstField");
		WebElement city = getWebElement("revPhone:city");
		WebElement search = getWebElement("revPhone:search");
		
			phone.clear();
			phone.sendKeys(phoneNumber);
			city.clear();
			city.sendKeys(cityName);
			search.click();
			//Thread.sleep(4000);
			System.out.println("Wakeup from sleep");
			WebElement searchResultsCount = getWebElementByXpath("//*[@id='contentSrchResult']/div[1]/div[1]/span");
			WebElement searchResultsPageCount = getWebElementByXpath("//*[@id='second']/span");
			WebElement firstButton = getWebElement("j_id10:FIRSTPGLink");
			WebElement nextButton = getWebElement("j_id10:PGDOWNLink");
			System.out.println("nextButton.isEnabled() --> "+ nextButton.isEnabled());

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
				System.out.println("--- Start Record " + k+ " ---");				
				WebElement table =null;
				try {
					table = driver.findElement(By.id("second:myTab"));
				} catch (Exception e) {
					Thread.sleep(15000);
					table = driver.findElement(By.id("second:myTab"));
				}
				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (int h = 0; allRows.size() > h; h++) {
					List<WebElement> cell = allRows.get(h).findElements(By.tagName("td"));
					if(cell.size()>0){
						cell.get(0).findElement(By.tagName("a")).click();
						Thread.sleep(2000);
						WebElement details = driver.findElement(By.id("customerDetails"));
						sb.append(getAddresss(details.findElement(By.tagName("table"))));
						details.findElement(By.className("back")).click();	
						Thread.sleep(3000);
						try {
							table = driver.findElement(By.id("second:myTab"));
						} catch (Exception e) {
							Thread.sleep(15000);
							table = driver.findElement(By.id("second:myTab"));
						}
						allRows = table.findElements(By.tagName("tr"));								
				    	sb.append("\n");
					}
				}
				System.out.println("---- end of " + k+ " Record -----");
				nextButton = driver.findElement(By.id("j_id10:PGDOWNLink"));
				System.out.println("nextButton.isEnabled() --> "+ nextButton.isEnabled());
				nextButton.click();
				Thread.sleep(2000);

			}

		} catch (Exception e) {
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
		//	do {
				i++;
//				fout = new File(basepath + "NotFound_" + content + "_" + i
//						+ ".txt");
				fout = new File(basepath + "NotFound.txt");
			//} while (fout.exists());

			FileWriter fw = new FileWriter(fout,true);
			fw.write(output+"\n");
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
	

	synchronized WebElement getWebElement(String path){
		WebDriverWait wait = new WebDriverWait(driver,180);
		WebElement re=wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(path))));
		wait=null;
		return re;
	}

	synchronized WebElement getWebElementByXpath(String path){
		WebDriverWait wait = new WebDriverWait(driver,180);
		WebElement re=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		wait=null;
		return re;
		
	}

	
	synchronized WebElement getWebElementByWebElement(String path){
		WebDriverWait wait = new WebDriverWait(driver,180);
		WebElement re=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		wait=null;
		return re;
		
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
		//System.out.println(sb.toString());
		return sb.toString();
	}

	class Driver extends HtmlUnitDriver implements Cloneable {
		
		public Driver(boolean html) {
			super(html);
		}
		
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
			}

		
	}
}
