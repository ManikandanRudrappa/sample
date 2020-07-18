package smp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Smp1 {
	@Test

	public static void main(String[] args)
{

		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//SearchPage
		WebElement search=driver.findElementById("twotabsearchtextbox");
		search.sendKeys("iphone 11");
		search.sendKeys(Keys.ENTER);
		driver.findElementByXPath("//span[text()='Apple iPhone 11 (64GB) - White'][1]").click();
		
		
		Set<String> winhand = driver.getWindowHandles();
		List<String> winhand1 =new ArrayList(winhand);
		driver.switchTo().window(winhand1.get(1));
		
		//driver.findElementByXPath("(//img[@class='imgSwatch'])[2]").click();
		
		//WebElement drop = driver.findElementById("quantity");
		//Select sel = new Select(drop);
		//sel.selectByVisibleText("3");
		
		//AddToCartPage
		driver.findElementById("add-to-cart-button").click();
		
		//ProceedToBuyPage
		driver.findElementByXPath("(//a[@class='a-button-text a-text-center'])[1]").click();
		
		//CredentialsPage
		driver.findElementByXPath("//input[@type='email']").sendKeys("9987870509");
		driver.findElementById("continue").click();
		driver.findElementByXPath("//input[@type='password']").sendKeys("Selenium@123");
		driver.findElementById("signInSubmit").click();
		
		//DeliveryPage
		driver.findElementByXPath("(//a[@class='a-declarative a-button-text '])[1]").click();
		
		//FetchDetailsPage
		String ProductName = driver.findElementByXPath("//p[text()='Apple iPhone 11 (64GB) - White']").getText();
		System.out.println("The name of the product you ordered is: "+ProductName);
		String ProdPrice = driver.findElementByXPath("//span[text()='68,300.00']").getText();
		System.out.println("The price of the product you ordered is:"+ProdPrice);
		
		driver.quit();

	}

	}
