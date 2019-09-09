package Elements;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;

public class Reach_First_Use_Elements {

	




	





			
			//Instantiate web driver
					WebDriver driver_Reach_First_Use_Notice;
					//Cornwall First use Notice elements
					By green_tab= By.className("triangle__3TvaE");																	//green tab		
					By Reach_First_use_Login=By.xpath("//*[@id=\"btn_login\"]");												//login to agate
					By Reach_First_Use_CreateWallet= By.xpath("//*[@id=\"btn_cta\"]");
					By Reach_First_Use_I_Got_Digital_Subs = By.xpath("//*[@id=\"first_use__btn_subscribe\"]");
					By Reach_First_Use_Learn_More = By.xpath("/html/body/div/div/div/div/div/section/button[2]");	
					
					public Reach_First_Use_Elements(WebDriver driver_Reach_First_Use_Notice2) {							//constructor
						this.driver_Reach_First_Use_Notice= driver_Reach_First_Use_Notice2;
						}
				
				

					public void Click_On_Reach_First_use_Login_button() throws InterruptedException {					
						Thread.sleep(4000);
						JavascriptExecutor js = (JavascriptExecutor)driver_Reach_First_Use_Notice;
						js.executeScript("window.scrollBy(0,800)");
						Thread.sleep(2000);
						WebElement frame = 	driver_Reach_First_Use_Notice.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
						driver_Reach_First_Use_Notice.switchTo().frame(frame);
						WebElement Reach_First_use_Login= driver_Reach_First_Use_Notice.findElement(By.id("btn_login"));
						JavascriptExecutor executor = (JavascriptExecutor)driver_Reach_First_Use_Notice;
						executor.executeScript("arguments[0].click();", Reach_First_use_Login);		
						}
				
					
					
					
					
					
				
					public void Click_On_Reach_First_Use_CreateWallet() throws InterruptedException, IOException {						
						Thread.sleep(4000);
						JavascriptExecutor js = (JavascriptExecutor)driver_Reach_First_Use_Notice;
						js.executeScript("window.scrollBy(0,400)");
						Thread.sleep(2000);	
						
						
						WebElement frame = 	driver_Reach_First_Use_Notice.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
						driver_Reach_First_Use_Notice.switchTo().frame(frame);	
						
						
						Boolean finding = driver_Reach_First_Use_Notice.findElement(By.xpath("//*[@id=\"btn_cta\"]")).isDisplayed();
						System.out.println(finding);
						
						WebElement section = 	driver_Reach_First_Use_Notice.findElement(By.id("agate_section"));
						
						
						
						js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",section);
						WebElement Reach_First_Use_CreateWallet= driver_Reach_First_Use_Notice.findElement(By.xpath("//*[@id=\"btn_cta\"]"));
					
						Thread.sleep(4000);
						
						
						Thread.sleep(4000);
						JavascriptExecutor executor = (JavascriptExecutor)driver_Reach_First_Use_Notice;
						executor.executeScript("arguments[0].click();", Reach_First_Use_CreateWallet);
						
						
						
						
						driver_Reach_First_Use_Notice.switchTo().defaultContent();
						}
				
				
			
			
			
			
			
			
			
			
	

		
		
		
		
		
		
		
		
		


	
	
	
	
	
	
	
	
}
