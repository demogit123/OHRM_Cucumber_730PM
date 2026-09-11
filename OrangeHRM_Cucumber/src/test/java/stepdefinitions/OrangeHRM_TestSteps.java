package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM_TestSteps 
{

	public static WebDriver driver;
	public WebElement loginButton;
	String empid;
	
	@Given("I Open Browser with URL {string}")
	public void i_open_browser_with_url(String url) {
	    
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Then("I should see Login Page")
	public void i_should_see_login_page() 
	{
		loginButton = driver.findElement(By.id("btnLogin"));
		Assert.assertTrue(loginButton.isDisplayed());
		
	}
	
	@When("I Enter Username as {string}")
	public void i_enter_username_as(String uname) {
	 driver.findElement(By.id("txtUsername")).sendKeys(uname);		
	}
	
	@When("I Enter Password as {string}")
	public void i_enter_password_as(String pword) {
	   driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}
	@When("I Click Login")
	public void i_click_login() 
	{
		loginButton.click();
	}
	
	@Then("I sholud see Admin Module")
	public void i_sholud_see_admin_module() {
	  
		WebElement adminLink;
		adminLink = driver.findElement(By.linkText("Admin"));
		Assert.assertTrue(adminLink.isDisplayed());
	}
	
	@When("I Click Logout")
	public void i_click_logout() 
	{
	    driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}
	@When("I Close Browser")
	public void i_close_browser()
	{
	    driver.close();
	}
	
	@Then("I Should see Error Message")
	public void isErrMsgDisplayed()
	{
		String errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		boolean res;
		if(errmsg.contains("invalid") || errmsg.contains("empty"))
		{
			res = true;
		}else
		{
			res = false;
		}
		
		Assert.assertTrue(res);
	}
	
	@When("I Goto Add Employee Page")
	public void i_goto_add_employee_page() 
	{
	   driver.findElement(By.linkText("PIM")).click();
	   driver.findElement(By.linkText("Add Employee")).click();
		
	}
	@When("I Enter FirstName as {string}")
	public void i_enter_first_name_as(String fname) 
	{
	    driver.findElement(By.id("firstName")).sendKeys(fname);
	}
	
	
	@When("I Enter LastName as {string}")
	public void i_enter_last_name_as(String lname)
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}
	@When("I Click Save")
	public void i_click_save() 
	{
	   empid = driver.findElement(By.id("employeeId")).getAttribute("value");
	   driver.findElement(By.id("btnSave")).click();
	   
	}
	
	@Then("I Should See Registred Employee in Employee List")
	public boolean i_should_see_registred_employee_in_employee_list() 
	{
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		WebElement emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		
		boolean res = false;
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				res = true;
				break;
			}
		}
		return res;
		
	}
}
