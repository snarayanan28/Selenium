package com.demo.example;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class DemoOne {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Selenium_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void qaAcademy() throws Exception	{		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement wRadio, wText, wChkbox;
		
		wRadio = driver.findElement(By.xpath("//input[@value='radio1']"));
		wRadio.click();
		wText = driver.findElement(By.id("autocomplete"));
		wText.sendKeys("India");
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByValue("option2");
		driver.findElement(By.name("checkBoxOption1")).click();
		wChkbox = driver.findElement(By.name("checkBoxOption2"));
		wChkbox.click();
		
		//	Window Handling
		String parentWndHandle = driver.getWindowHandle();	// Get the current window handle
		System.out.println("The Parent Win Handle is : " + parentWndHandle);		
		WebElement openWnd = driver.findElement(By.id("openwindow"));	// Click the button to open a new window
		openWnd.click();
		
		// Handling multiple windows 
		Set<String>winHandles = driver.getWindowHandles();
		for(String handle : winHandles)	
		{
			if(!handle.equals(parentWndHandle))
			{
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				System.out.println("Tile of the new window " + driver.getTitle());
			}
		}
		
		driver.switchTo().window(parentWndHandle);	//	Switching the control back to the parent window
		System.out.println("Parent window URL: " + driver.getCurrentUrl());		
		
		//	Handling Open Tab functionality
		driver.findElement(By.id("opentab")).click();	//	Click on Open Tab link
		driver.getTitle();
		driver.switchTo().defaultContent();	//	To Switch back to the original tab

		//	Handling Alerts
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Chandrasekar");
		driver.findElement(By.id("alertbtn")).click();	//	Click on Alert button
		Alert alertBox = driver.switchTo().alert();
		alertBox.accept();
		
		driver.findElement(By.id("confirmbtn")).click();	//	Click on Confirm button
		Alert confirmBox = driver.switchTo().alert();
		confirmBox.dismiss();
	}
	
  	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
