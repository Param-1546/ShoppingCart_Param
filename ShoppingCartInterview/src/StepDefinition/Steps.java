package StepDefinition;		

import java.sql.Array;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.*;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Steps {
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
	
    @Given("^Open the Edge and launch the application$")					
    public void open_the_Edge_and_launch_the_application() throws Throwable							
    {		
       					
    }	
    @Given("^I add four random items to my cart$")
    public void I_add_four_random_items_to_my_cart() throws Throwable							
    {
    	try {
    	for (int i = 0; i < 3; i++)
        {
            driver.findElement(By.xpath("//div [@class='columns-3']/ul/li[" + i + "]/div/a[2]")).click();

        }}
    	catch(Exception e) {}
    }
    
    @When("^I view my cart$")
    public void I_view_my_cart() throws Throwable							
    {
    	try {
    	driver.findElement(By.xpath("//div[@class = \"ellie-thumb-wrapper\"][1]/a[3]")).click();
    	}
    	catch(Exception e) {}
    }
    
    @SuppressWarnings("deprecation")
	@Then("^I find total four items listed in my cart$")
    public void I_find_total_four_items_listed_in_my_cart() throws Throwable							
    {
    	try {
    	itemsList = driver.findElements(By.xpath("//table[@class = \"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr"));
   		Assert.assertEquals(4, itemsList.size());
    }
	catch(Exception e) {}
    }
    
    @When("^I searched for the lowest price item$")
    public void I_searched_for_the_lowest_price_item() throws Throwable							
    {
    	try {
    	for(i=0;i<4;i++)
    	{
    		a[i] = Integer.valueOf(driver.findElement(By.xpath("//table[@class = \"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr[" + i + "]/td[6]/span/span")).getText());
    	}
    	}
    	catch(Exception e) {}
    }
    
    @When("^I am able to remove the lowest price item from my cart$")
    public void I_am_able_to_remove_the_lowest_price_item_from_my_cart() throws Throwable							
    {
    	try {
    	i = FindSmallestElement(a);
    	driver.findElement(By.xpath("//table[@class = \"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr[" + i + "]/td[1]/a")).click();
    	}
    	catch(Exception e) {}
    }
    
	private int FindSmallestElement(int[] arr1) {
		int index = arr1[0];
		for (int i=1; i<arr1.length; i++)
		{
			if (arr1[i] > index )
			{
				index = arr1[i];
				return index ;
			}
		}
		return 0;
		
	}
	@SuppressWarnings("deprecation")
	@Then("^I am able to verify three items in my cart$")
    public void I_am_able_to_verify_three_items_in_my_cart() throws Throwable							
    {
		try {
    	itemsList = driver.findElements(By.xpath("//table[@class = \"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr"));
   		Assert.assertEquals(3, itemsList.size());
		}
    	catch(Exception e) {}
    }
	
    @Then("^Close the browser$")					
    public void Close_the_browser() throws Throwable 							
    {		
       driver.close();				
    }	

}