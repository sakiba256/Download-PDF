package sakiba.com;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CloudApper extends DriverSetup{

	public static WebElement element;
	//Get Url from Config file Read data
	public static String baseURL=getURL("SeleniumUrl");
	@Test
	public static void download() throws InterruptedException{
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		String parentWindow = driver.getWindowHandle();
		 WebElement pdfLink = driver.findElement(By.linkText("Download a Printable PDF of this Cheat Sheet"));
		 pdfLink.click();
		 Thread.sleep(100000);
	   
          //Switching the wing while open pdf preview
		 for (String windowHandle : driver.getWindowHandles()) {
			    if(!parentWindow.contentEquals(windowHandle)) {
			        driver.switchTo().window(windowHandle);
					 Thread.sleep(1000);
					 driver.switchTo().window(parentWindow);
					 //Get Elelment by href link to find out the link from Attribute
					 WebElement downloadLink = driver.findElement(By.xpath("//a[contains(@href, '.pdf')]"));				  
			            String pdfUrl = downloadLink.getAttribute("href");
			            System.out.println("Download URL found: " + pdfUrl);
			            //Download file 
			            downloadFile(pdfUrl, "Selenium_Cheet_Sheet.pdf");
				       //Validation Check 
				        if (Files.exists(Paths.get("Selenium_Cheet_Sheet.pdf"))) {
				            System.out.println("PDF file downloaded successfully.");
				        } else {
				            System.out.println("PDF file not downloaded.");
				        }

			    }
			}
		 
		 System.out.println("Done");
		 Thread.sleep(1000);
	}
	
	
	

}
