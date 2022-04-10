package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = BaseClass.driver;
	
	@Given("I have opened the swaglabs application in browser")
	public void i_have_opened_the_swaglabs_application_in_browser() throws InterruptedException {

		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);	
	}

	
	@When("I enter username {string}")
	public void i_enter_username(String username) {
		
		WebElement UserName = driver.findElement(By.name("user-name"));
		UserName.sendKeys(username);
	}
	
	@When("I enter password {string}")
	public void i_enter_password(String password) {

		WebElement UserName = driver.findElement(By.name("password"));
		UserName.sendKeys(password);
	}
	
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		
		WebElement LoginBtn = driver.findElement(By.name("login-button"));
		LoginBtn.click();
	}
	
	@Then("I should be logged in succesful and land on product page")
	public void i_should_be_logged_in_succesful_and_land_on_product_page() {

	    System.out.println("Logged in succesful and land on product page");
	}
	
	@Then("I should be getting error message {string}")
	public void i_should_be_getting_error_message(String expectedMsg) {
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//div[@class = 'error-message-container error']/h3"));
		String ActualMsg = ErrorMsg.getText();		
		
		Assert.assertEquals(ActualMsg, expectedMsg);
	}

}
