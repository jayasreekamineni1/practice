package Elements;


import java.io.IOException;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class New_Pub_Notice {
	
WebDriver driver_newpub_notice;

	
	
	By New_Pub_Just_Charge_Me= By.xpath("/html/body/div/div/div/div/div/div/div/div[1]/div[1]/div");
	
	
	By Newpub_Notice_continue_reading=By.id("agate_payNow");
	
	
	public New_Pub_Notice(WebDriver driver_newpub_notice2) 
	{
	this.driver_newpub_notice= driver_newpub_notice2;
	}
	
	
	public void Newpub_charge_off() throws InterruptedException{
		
		WebElement frame =driver_newpub_notice.findElement((By.id("iframe__inpage_notices")));
		Thread.sleep(6000);
		driver_newpub_notice.switchTo().frame(frame);			
	driver_newpub_notice.findElement(New_Pub_Just_Charge_Me).click();
	driver_newpub_notice.switchTo().defaultContent();
	}
	
	
	public void authorise_charge_notice_click_continue() throws IOException, InterruptedException
	{

		Thread.sleep(6000);	
		WebElement frame =driver_newpub_notice.findElement((By.id("iframe__inpage_notices")));
		Thread.sleep(6000);
		driver_newpub_notice.switchTo().frame(frame);			
		driver_newpub_notice.findElement(Newpub_Notice_continue_reading).click();
		driver_newpub_notice.switchTo().defaultContent();
		Thread.sleep(8000);
		
		
	}
	
	
	

}
