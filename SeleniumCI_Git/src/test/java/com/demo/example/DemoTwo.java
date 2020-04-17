package com.demo.example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class DemoTwo {
	WebDriver driver;
	
	@BeforeClass	
	public void setUp() throws Exception	{
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Selenium_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void toolsQA() throws Exception	{
			driver.get("https://www.toolsqa.com/");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			//	To retrieve the Class object that represents the runtime class of this object
			System.out.println("The class name is : " + driver.getClass());
			//	To retrieve the URL of the web page the user is currently accessing
			System.out.println("The current URL of the page is : " + driver.getCurrentUrl());
			//	To retrieve the page source	of the web page the user is currently accessing
			boolean result = driver.getPageSource().contains("Selenium  tutorial");
			System.out.println("The result of this page source is: " + result);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Selenium Online Trainings']"))));
			driver.findElement(By.xpath("//img[@alt='close-link']")).click();		
			
			Actions builder = new Actions(driver);
			// Locate the element by mouse hover to Tutorial
			WebElement mainMenu = driver.findElement(By.xpath("(//span[text()='Tutorial'])[1]"));
			mainMenu.click();
			// Locate the element by mouse hover to Front-End Testing Automation
			builder.moveToElement(mainMenu).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();
			//Thread.sleep(2000);
			
			// Locate the element by mouse hover to Selenium Tutorial in Java
			WebElement subMenu = driver.findElement(By.xpath("(//span[text()='Selenium in Java'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(subMenu));
			builder.moveToElement(subMenu).click().build().perform();
			//Thread.sleep(2500);
			
			//	Locate elements using LinkText and Partial Link Text
			WebElement headerEle = driver.findElement(By.xpath("//h1[contains(text(),'Selenium Tutorial')]"));
			wait.until(ExpectedConditions.visibilityOf(headerEle));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			
			//jse.executeScript("arguments[0].scrollIntoView();", element);		//This will scroll the page till the element is found
			jse.executeScript("window.scrollBy(0,700)");
			driver.findElement(By.linkText("Set Up Java"));
			driver.navigate().to("https://www.toolsqa.com/selenium-webdriver/install-java/");
			
			//	To retrieve the title of the webpage the user is currently working on.
			String strTitle =driver.getTitle();
			System.out.println("The title of the current page is " + strTitle);
			
			WebElement wePageTitle = driver.findElement(By.xpath("//h1[text()='Install Java']"));
			wait.until(ExpectedConditions.visibilityOf(wePageTitle));			
			//	Click the search icon
			WebElement weSearch = driver.findElement(By.xpath("(//a[contains(@class,'submit')])[1]"));
			builder.moveToElement(weSearch).click().build().perform();
			WebElement weSearchText = driver.findElement(By.id("the7-micro-widget-search"));
			weSearchText.click();
			weSearchText.clear();
			weSearchText.sendKeys("Exceptions");
	
			//To retrieve the value of the specified attribute
			@SuppressWarnings("unused")
			String sText = weSearchText.getAttribute("value");
			System.out.println("Entered value in the Search Textbox is: " +sText);
			driver.close();
		}

	@AfterClass
	public void tearDown() throws Exception	{
		driver.quit();
	}

}
