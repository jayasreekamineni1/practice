package Stepdef;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Elements.Authorise_charge_notice_popbitch;
import Elements.Login_Page_Elements;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import Elements.Reaction_first_use_notice;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Reaction_Transaction {
	WebDriver driver_Reaction_Transaction;
	double expected_balance_global;
	double expected_balance;

	
	@Given("I am a registered Agate User and I login in to Reaction")
	@Test(priority=12)
	@Parameters("browser")
	public void i_am_a_registered_Agate_User_and_I_login_in_to_Reaction(String browser) throws IOException, InterruptedException {
		if(browser.equalsIgnoreCase("firefox")) {
			driver_Reaction_Transaction = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("safari")) { 

			driver_Reaction_Transaction= new SafariDriver();
		} 

		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_Reaction_Transaction= new ChromeDriver();
		} 
		
		
		System.out.println("\n"+"POPBITCH TRANSACTION"+"\n");
		System.out.println("\n"+""+"\n");
	
		driver_Reaction_Transaction.get("https://reaction.life/time-look-past-tories-corbyn-spring-coming/");
		Thread.sleep(3000);
		String popbitch_navigation= driver_Reaction_Transaction.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://reaction.life/time-look-past-tories-corbyn-spring-coming/"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open popbitch staging ");
			throw e0;
		}
	    System.out.println("Popbitch staging is ready to be tested");
		
		//call first use notice elements of reaction
				Thread.sleep(15000);
				Reaction_first_use_notice Reac_first_use_register1 = new Reaction_first_use_notice(driver_Reaction_Transaction);	
				Reac_first_use_register1.Click_On_Reaction_First_use_Login_button(); 
				System.out.println("\n"+"Clicked on Create wallet.. Now lets see if this takes us to Sign up page"+"\n");	
	
		Thread.sleep(8000);
		
		Thread.sleep(2000);
		String Login_From_PopBitch_Frist_Use_Notice_Current_Url= driver_Reaction_Transaction.getCurrentUrl();
	    System.out.println("\n"+"Clicking on login redirected to login page satging"+"\n");
	    assertTrue(Login_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-in?"));
	    System.out.println("\n"+"Successfully navigated to login page"+"\n");
	
	
	    Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_Reaction_Transaction);
		Thread.sleep(2000);
		Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
		Thread.sleep(10000);
		
		System.out.println("\n"+"Login successfull"+"\n");
	}

	@When("I read a premium article on reaction")
	@Test(priority=13)
	public void i_read_a_premium_article_on_reaction() throws IOException, InterruptedException {
		//click ok on authorise charge notice
		//scroll for full article
		JavascriptExecutor js0 = (JavascriptExecutor)driver_Reaction_Transaction;
		js0.executeScript("window.scrollBy(0,800)");
		
		
		
		
		Thread.sleep(10000);
				Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Reaction_Transaction);
				authy_popbitch.authorise_charge_notice_click_continue();
				Thread.sleep(3000);
			
				
				//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				
				
			//check if the wallket is being deducted by 30 p
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Transaction);
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
								
			//convert string balances to double
				double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
				double expected_balance_to_be_deducted = 0.30;
				double balance_after_first_article= 1.40;
				double actual_balance_being_deducted= balance_after_first_article-actual_balance_after_reacding_first_article;
				DecimalFormat df = new DecimalFormat("#.##");
				actual_balance_being_deducted = Double.valueOf(df.format(actual_balance_being_deducted));						
		
				
				//verify whether the expected balance is the actual balance
				AssertJUnit.assertEquals(expected_balance_to_be_deducted, actual_balance_being_deducted);
				if(actual_balance_being_deducted==expected_balance_to_be_deducted)
				{
					System.out.println("Balance is expected to be deducted by"+actual_balance_after_reacding_first_article );
													
				}
				else
				{
					System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_after_reacding_first_article+ "please check, it should be  "+ expected_balance_to_be_deducted );
				}		
				
				
				
				
				
	}

	@Then("the wallet balance and free point are deducted by x amount on reaction wallet")
	@Test(priority=14)
	public void the_wallet_balance_and_free_point_are_deducted_by_x_amount_on_reaction_wallet() throws InterruptedException, IOException {
		//Read a third article on reaction
		driver_Reaction_Transaction.navigate().to("https://reaction.life/referendums-prove-sovereign/");
				Thread.sleep(4000);	
				String popbitch_navigation= driver_Reaction_Transaction.getCurrentUrl();
			    try
				{
			    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://reaction.life/referendums-prove-sovereign/"));
				}catch(AssertionError e0)
				{
					System.out.println("Browser did not open popbitch staging ");
					throw e0;
				}
			    System.out.println("Popbitch staging is ready to be tested");
				
				//click ok on authorise charge notice
				
				//scroll for full article
				JavascriptExecutor js0 = (JavascriptExecutor)driver_Reaction_Transaction;
				js0.executeScript("window.scrollBy(0,800)");
				
				
				Thread.sleep(10000);
				Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Reaction_Transaction);
				authy_popbitch.authorise_charge_notice_click_continue();
				Thread.sleep(3000);
			
				
				//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				
				
			//check if the wallet is being deducted by 30 p
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Transaction);
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
								
			//convert string balances to double
				double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
				double expected_balance_to_be_deducted = 0.30;
				double balance_after_first_article= 1.10;
				double actual_balance_being_deducted= balance_after_first_article-actual_balance_after_reacding_first_article;
				DecimalFormat df = new DecimalFormat("#.##");
				actual_balance_being_deducted = Double.valueOf(df.format(actual_balance_being_deducted));						
		
				
				//verify whether the expected balance is the actual balance
				AssertJUnit.assertEquals(expected_balance_to_be_deducted, actual_balance_being_deducted);
				if(actual_balance_being_deducted==expected_balance_to_be_deducted)
				{
					System.out.println("Balance is expected to be deducted by"+actual_balance_after_reacding_first_article );
													
				}
				else
				{
					System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_after_reacding_first_article+ "please check, it should be  "+ expected_balance_to_be_deducted );
				}		
				
				//Navigate to a fifth article which is supposed to be free
				driver_Reaction_Transaction.navigate().to("https://reaction.life/chequers-dead-maybot-reset-required/");
				Thread.sleep(4000);	
				
				
				
				
				
				
	}

	@Then("The popbitch wallet balance is updated , same as reaction and free point remains uneffected")
	@Test(priority=15)
	public void the_popbitch_wallet_balance_is_updated_same_as_reaction_and_free_point_remains_uneffected() throws InterruptedException, IOException {
		driver_Reaction_Transaction.navigate().to("https://popbitch.com/2019/02/tat-for-tits/");
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Transaction);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			

				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Transaction); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 0.80;
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance, balance_after);
			if(balance_after==expected_balance)
			{
				System.out.println("Balance is expected to be "+balance_after );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+balance_after+ "please check, it should be  "+ expected_balance );
			}	
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			
		/*//GET FREE POINT AFTER THE TWO TRANSACTIONS
			Thread.sleep(2000); 
			String free_point_after_2_articles_string= wallet_elements_1.Free_point();
			//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
			String Popbitch_expected_free_point_after_2_articles= "until free";
			//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
			//int Popbitch_expected_free_point_after_2_articles= 0;
				
				//Verify if actual free point matches expected free point
					AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
					if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
					{
						System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
						
					}
					else
					{
						
						System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
				
					}
			
			*/
	
			
		
	}

	@Then("Cricketer wallet balance is updated and free point remains uneffected")
	@Test(priority=16)
	public void cricketer_wallet_balance_is_updated_and_free_point_remains_uneffected() throws InterruptedException, IOException {
		driver_Reaction_Transaction.navigate().to("https://www.thecricketer.com/Topics/premimum_features/englishman_in_antigua_johnny_grave_is_in_charge_of_west_indies_cricket_trying_to_lead_a_renaissance_and_beating_joe_roots_men_did_no_harm.html");
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Transaction);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
		
		
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Transaction); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 0.80;
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance, balance_after);
			if(balance_after==expected_balance)
			{
				System.out.println("Balance is expected to be "+balance_after );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+balance_after+ "please check, it should be  "+ expected_balance );
			}	
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			
	/*	//GET FREE POINT AFTER THE TWO TRANSACTIONS
			Thread.sleep(2000); 
			String free_point_after_2_articles_string= wallet_elements_1.Free_point();
			//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
			String Popbitch_expected_free_point_after_2_articles= "until free";
			//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
			//int Popbitch_expected_free_point_after_2_articles= 0;
				
				//Verify if actual free point matches expected free point
					AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
					if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
					{
						System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
						
					}
					else
					{
						
						System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
				
					}
			
			
			System.out.println("\n"+"wallet balance on cricketer is "+balance_after+"\n");
			//System.out.println("\n"+"free point on reaction is £1.20"+"\n");
		*/
	}


	@Then("Cornwall wallet balance remains and is uneffected")
	@Test(priority=17)
	public void Cornwall_wallet_balance_remains_and_is_uneffected() throws InterruptedException, IOException {
		driver_Reaction_Transaction.navigate().to("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/");
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Transaction);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
		
		
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Transaction); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 0.80;
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance, balance_after);
			if(balance_after==expected_balance)
			{
				System.out.println("Balance is expected to be "+balance_after );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+balance_after+ "please check, it should be  "+ expected_balance );
			}	
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			
	/*	//GET FREE POINT AFTER THE TWO TRANSACTIONS
			Thread.sleep(2000); 
			String free_point_after_2_articles_string= wallet_elements_1.Free_point();
			//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
			String Popbitch_expected_free_point_after_2_articles= "until free";
			//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
			//int Popbitch_expected_free_point_after_2_articles= 0;
				
				//Verify if actual free point matches expected free point
					AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
					if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
					{
						System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
						
					}
					else
					{
						
						System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
				
					}*/
			
	}
	
}
