package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.*;

public class TestSteps{
	public static WebDriver driver ;
	
	@Given("^navigate to GoalPlan$")
	public void navigate_to_GoalPlan() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.ourgoalplan.com");
		driver.manage().window().maximize();
	   System.out.println("inside navigate:" + driver);
	}
	
	@When("^User enters Credentials to log in$")
	public  void user_enters_Credentials_to_log_in(DataTable credentials) throws Throwable {
	    LoginPage log = new LoginPage();
		List<List<String>> data = credentials.raw();
	    System.out.println("inside logged in:" + driver);
	    log.enterUserName(data.get(0).get(0));
	    log.enterPassword(data.get(0).get(1));
	    log.clickLoginButtton();
	  
	}
	
	@Then("^User should see the home page$")
	public void user_should_see_the_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("user Logged in");
	}
	
	
	@When("^User logout from application$")
	public  void user_logout_from_application() throws Throwable {
	   driver.findElement(By.linkText("Logout")).click();
	}
	
	
	@Then("^user should see the Login page$")
	public void user_should_see_the_Login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("user logged out");
	    driver.close();
	}
	
	@When("^User enters  Username as \"([^\"]*)\"  and  Password as \"([^\"]*)\"$")
	public  void user_enters_Username_as_and_Password_as(String username, String password) throws Throwable {
		LoginPage log = new LoginPage();
		log.enterUserName(username);
		log.enterPassword(password);
		log.clickLoginButtton();
		
	}
	
	@Then("^User should see the approriate message$")
	public void user_should_see_the_approriate_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.xpath("//span[@id = 'lblValidation']")).getText().equals("Invalid Password")) {
	   System.out.println("invalid password");
   	}
		else {
			System.out.println("Invalid email");
		}
		driver.close();
	  }

	

}
