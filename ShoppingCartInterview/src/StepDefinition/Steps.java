package StepDefinition;		

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.*;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class Steps{
	static WebDriver driver;
	public List<WebElement> itemsList;
	int i = 0;
	public int[] a = new int[4];
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");					
	       driver= new EdgeDriver();					
	       driver.manage().window().maximize();			
	       driver.get("https://cms.demo.katalon.com/");
	}	
		
    @Given("^I add four random items to my cart$")
    public void I_add_four_random_items_to_my_cart() throws Throwable							
    {
    	try {
    	for (int i = 0; i < 3; i++)
        {
            driver.findElement(By.xpath(Locators.AddItem_1 + i + Locators.AddItem_2)).click();

        }}
    	catch(Exception e) {}
    }
    
    @When("^I view my cart$")
    public void I_view_my_cart() throws Throwable							
    {
    	try {
    	driver.findElement(By.xpath(Locators.ViewCart)).click();
    	}
    	catch(Exception e) {}
    }
    
    @SuppressWarnings("deprecation")
	@Then("^I find total four items listed in my cart$")
    public void I_find_total_four_items_listed_in_my_cart() throws Throwable							
    {
    	try {
    	itemsList = driver.findElements(By.xpath(Locators.ListOfItems));
   		Assert.assertEquals(4, itemsList.size()-1);
    }
	catch(Exception e) {}
    }
    
    @When("^I searched for the lowest price item$")
    public void I_searched_for_the_lowest_price_item() throws Throwable							
    {
    	try {
    	for(i=0;i<4;i++)
    	{
    		a[i] = Integer.valueOf(driver.findElement(By.xpath(Locators.LowestPriceItem_1 + i + Locators.LowestPriceItem_2)).getText());
    	}
    	}
    	catch(Exception e) {}
    }
    
    @When("^I am able to remove the lowest price item from my cart$")
    public void I_am_able_to_remove_the_lowest_price_item_from_my_cart() throws Throwable							
    {
    	try {
    	i = ReUsabeFunc.FindSmallestElement(a);
    	driver.findElement(By.xpath(Locators.DeleteItem_1 + i + Locators.DeleteItem_2)).click();
    	}
    	catch(Exception e) {}
    }
    
	
	@SuppressWarnings("deprecation")
	@Then("^I am able to verify three items in my cart$")
    public void I_am_able_to_verify_three_items_in_my_cart() throws Throwable							
    {
		try {
    	itemsList = driver.findElements(By.xpath(Locators.ListOfItems));
   		Assert.assertEquals(3, itemsList.size()-1);
		}
    	catch(Exception e) {}
    }
}
