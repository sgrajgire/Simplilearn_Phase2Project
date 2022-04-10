package stepDefs;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateSteps {

	WebDriver driver = BaseClass.driver;

	@When("I have logged in successful")
	public void i_have_logged_in_successful() {
		WebElement UserName = driver.findElement(By.name("user-name"));
		UserName.sendKeys("standard_user");
		
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys("secret_sauce");
		
		WebElement LoginBtn = driver.findElement(By.name("login-button"));
		LoginBtn.click();
	}
	
	@Then("Validate {string} and {string}")
	public void validate_and(String product, String expected_price) {
	    
		// //div[text()='Sauce Labs Backpack']/following::div[@class='inventory_item_price'][1]
		WebElement price_element = driver.findElement(By.xpath("//*[text()='" + product + "']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']"));
		String actual_price = price_element.getText();

		Assert.assertEquals(actual_price, expected_price);
	}
	

	@When("I pass below prodcuts")
	public void i_pass_below_prodcuts(Map<String, String> products) {
		
		for (String product: products.keySet()) {
			
			String expected_price = products.get(product);
			WebElement price_element = driver.findElement(By.xpath("//div[text()='" + product + "']/following::div[@class='inventory_item_price'][1]"));
			String actual_price = price_element.getText();

			Assert.assertEquals(actual_price, expected_price);
		}
	}
	
	@Then("I should validate product prices successful")
	public void i_should_validate_product_prices_successful() {
	    System.out.println("Validation successful");
	}
}
