import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class test {
		public HtmlUnitDriver driver;
		public String URL;
		public StringBuffer errors;
		static Logger logger = Logger.getLogger("");

		
		public void testSetupEnvironment() throws InterruptedException{
			driver = new HtmlUnitDriver(true);
			URL ="http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";			
		}
		
	public static void main (String a[]) throws Exception{
		logger.setLevel(Level.OFF);
		test bt = new test();
		bt.testSetupEnvironment();
		System.out.println("Completed Setup");
		bt.testGetPhoneNumbers();
		System.out.println("Completed getPhoneNumbers");
		bt.testTearDown();
		System.out.println("TearDown");
		
	}
		
		
		public void testGetPhoneNumbers() throws InterruptedException{
			driver.get(URL);
			Thread.sleep(3000);
			WebElement phone = driver.findElement(By.id("revPhone:firstField"));
			WebElement city = driver.findElement(By.id("revPhone:city"));
			WebElement search = driver.findElement(By.id("revPhone:search"));
			
			try {
				phone.clear();
				phone.sendKeys("0001");
				city.clear();
				city.sendKeys("CHENNAI");
				search.click();
				Thread.sleep(3000);
				System.out.println("Wakeup from sleep");
				WebElement searchResultsCount = driver.findElement(By.xpath("//*[@id='contentSrchResult']/div[1]/div[1]/span"));
				WebElement searchResultsPageCount =driver.findElement(By.xpath("//*[@id='second']/span"));
				WebElement firstButton = driver.findElement(By.id("j_id10:FIRSTPGLink"));
				WebElement nextButton = driver.findElement(By.id("j_id10:PGDOWNLink"));
				System.out.println("nextButton.isEnabled() --> "+nextButton.isEnabled());
				
				String strPageCount = searchResultsPageCount.getText();
				String[] splitStr = strPageCount.split("of");
				System.out.println("First -- "+splitStr[0].trim() +"\n Second -- "+splitStr[1].trim());
				String totPageCount = splitStr[1].trim();
				
				
				Assert.assertTrue(firstButton.isDisplayed());
				System.out.println("Total Count"+searchResultsCount.getText());
				System.out.println("Total Page Count"+searchResultsPageCount.getText());
				System.out.println("Is First Button displayed"+firstButton.isDisplayed());
				
				Integer countPage;
				countPage = Integer.valueOf(totPageCount);
				WebElement ahref = null;
				System.out.println("Cout page ---- "+countPage);
				for(int k=0;k<countPage;k++){
					System.out.println("--------------- Start Record "+k+" ----------------");
					// Get Tables
					WebElement table = driver.findElement(By.id("second:myTab"));
					// get all the TR in the displayed table
					List<WebElement> allRows = table.findElements(By.tagName("tr"));
					// iterate now
					
					StringBuffer out = new StringBuffer();
					for(WebElement row : allRows){
						
						List<WebElement> cell = row.findElements(By.tagName("td"));
						
						try{
							WebElement ahr=cell.get(0);
						System.out.println("TTTT   "+ahr.getText());
						ahref=ahr.findElement(By.tagName("a"));
						System.out.println("TTTT1   "+ahref);
					

						
						ahref.click();
						Thread.sleep(1000);
						String source = driver.getPageSource();
		System.out.println(source);
		driver.findElement(By.id("customerDetails:back")).click();;
		Thread.sleep(500);
		table = driver.findElement(By.id("second:myTab"));
		allRows = table.findElements(By.tagName("tr"));
		
		
						}
						catch(Exception e){
							
						}
						
						for(WebElement cellValue: cell){
							System.out.println(cell);
								out.append(cellValue.getText());
								out.append("\t");
								System.out.println("???? is "+cellValue.getText());
								
							
								
								
	
							
						}
						out.append("\n");
					}
					System.out.println("--------------- end of "+k+" Record ----------------");
					
					System.out.println(out.toString());
					nextButton.click();
					Thread.sleep(1000);
					
				}
				
				
			
				
			} catch (RuntimeException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			
		}
		
		
		public void testTearDown(){
			driver.close();
			driver.quit();
		}

}
