package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.*;
public class LoginPage {
	
	public static WebDriver driver;
	public LoginPage() {
		driver = TestSteps.driver;
		System.out.println("inside constructor:"  + driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id  = "txtName")
	private WebElement login;
	
	@FindBy(id = "txtPassword")
	private  WebElement pass;
	
	@FindBy(name = "btnLogin")
	private  WebElement loginbtn;
	
	public  void enterUserName(String name) {
		login.sendKeys(name);
		System.out.println("hello");
		
	}
	
	public  void enterPassword(String password) {
		pass.sendKeys(password);
	}
	
	public  void clickLoginButtton() {
		loginbtn.click();
		
	}
	

}
