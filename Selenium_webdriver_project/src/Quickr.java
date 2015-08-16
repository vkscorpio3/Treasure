import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Quickr {

	public static void main(String[] args) throws InterruptedException {

		String basepath = "/home/ganesh/Desktop/Input/";
		String cityName = "PUDUKKOTTAI";

//		if (args[0] != null) {
//			basepath = args[0];
//		}
//		if (args[1] != null) {
//			cityName = args[1];
//		}

		Thread5Digit b = new Thread5Digit(basepath, cityName);
		Thread th = new Thread(b);
		th.start();
		

	}

}

class Thread5Digit implements Runnable {
	static Logger logger = Logger.getLogger("");
	public HtmlUnitDriver driver;
	public String URL;
	public StringBuffer errors;
	static long l = 0;
	String basepath = null;
	String cityName = null;

	public Thread5Digit(String path, String city) {
		this.basepath = path;
		this.cityName = city;
	}

	public void testSetupEnvironment() throws InterruptedException {
		driver = new HtmlUnitDriver(false);
		URL = "http://chennai.quikr.com/Land-Plot-For-Sale/w18222211430?page=";
	}

	public void run() {
		logger.setLevel(Level.OFF);

		String output = null;
		String phone = null;
		try {
			testSetupEnvironment();
			output = getPhoneNumbers(2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		testTearDown();

	}

	public synchronized String getPhoneNumbers(
			int count) throws InterruptedException {

		StringBuffer sb = new StringBuffer();
		int i=0;
		while(i<count){
		i++;
		driver.get(URL+i);		
		Thread.sleep(3000);
		
		WebElement premiumContainer = driver.findElement(By.id("a1d1topcontainer"));
		System.out.println(premiumContainer);
		List<WebElement> premiumADS=premiumContainer.findElements(By.className("snb_entire_ad"));
		System.out.println(premiumADS);
		
		WebElement container = driver.findElement(By.id("a1d1container"));
		System.out.println(container);
		List<WebElement> ads=container.findElements(By.className("snb_entire_ad"));
		System.out.println(ads);
		
		for (WebElement e:premiumADS){
			System.out.println(e.findElement(By.tagName("a")).getAttribute("href"));
		}
		
		for (WebElement e:ads){
			System.out.println(e.findElement(By.tagName("a")).getAttribute("href"));
		}
		}
		//System.out.println(driver.getPageSource());
		return sb.toString();

	}

	public synchronized void testTearDown() {
		driver.close();
		driver.quit();
		System.out.println("TearDown");

	}

}
