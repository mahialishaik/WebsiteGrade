package DemoApp;

import java.io.Reader;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Smoketest {
	
	WebDriver wd;
	
	@Before
	public void Openbrowser()
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Ali\\Selenium\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
	}
	
	
	
	@After
	public void closebrowser()
	
	{
		wd.close();
	}

	@Given("^open chrome website$")
	public void open_chrome_website() throws Throwable {
		

		wd.get("https://website.grader.com/");
		
	}

	@When("^provide the website name \"([^\"]*)\"$")
	public void provide_the_website_name(String websitename) throws Throwable {
		
		wd.findElement(By.cssSelector("input[type='text'][data-reactid='.0.0.0.3.0:0.0.1']")).sendKeys(websitename);
		//click the find button
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		jse.executeScript("scroll(0, 250)"); 
		wd.findElement(By.cssSelector("button[type='submit'][class='btn btn-lg btn-black']")).click();
		Thread.sleep(5000);
		
		
	}
	@Then("^check the score is less than or greated than \"(.*?)\"$")
	public void check_the_score_is_less_than_or_greated_than(String arg1) throws Throwable {
		String x2=wd.findElement(By.cssSelector("div[class='radial-inner-container'][data-reactid='.0.0.3.0.0.1.0.1.4']")).getText();
		System.out.println("The website Score is : " + x2);
		
		if(Integer.parseInt(x2) < 90)
		{

		Assert.assertFalse("Do Not Build as the score is less than 90", Integer.parseInt(x2) < 90);
	
		}
		
	}

	

	
}





