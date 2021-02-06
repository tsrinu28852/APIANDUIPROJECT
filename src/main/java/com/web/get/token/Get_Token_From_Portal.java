
package com.web.get.token;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author tsrin
 *
 */


public class Get_Token_From_Portal {

	String URL;
	WebDriver webDriver;
	String actualTitle;

	public Get_Token_From_Portal(WebDriver webDriver)
	{
		this.webDriver=webDriver;

	}

	public boolean CreateDriver()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//    	options.setBinary("C:/Users/AB09997/Transfer/Google Chrome/chrome.exe");
		//    	webDriver = new ChromeDriver(options);
		webDriver = new ChromeDriver(options);
		return true;
	}

	public void OpenURL(String url)
	{
		URL = url;
		webDriver.get(URL);
		webDriver.manage().window().maximize();
	}

	public String getTitle()
	{
		actualTitle = webDriver.getTitle();
		return actualTitle;
	}

	public void  CloseBrowser() throws IllegalMonitorStateException
	{

		webDriver.close();
		System.exit(0);

	}

	public void  Closeapp() throws IllegalMonitorStateException
	{

		webDriver.quit();


	}

	public void clickLink(String linkName)
	{
		webDriver.findElement(By.linkText(linkName));
	}

	public void clickSignIn()
	{
		webDriver.findElement(By.cssSelector("input[type='image'][value='Login']")).click();
	}
	public void clickSubmit()
	{
		webDriver.findElement(By.cssSelector("input[type='image'][name='register']")).click();
	}
	public void enterValueInTextField(String textProperty,String textvValue)
	{
		webDriver.findElement(By.name(textProperty)).sendKeys(textvValue);
	}

	public void logintoApp(String userName,String passWord)
	{
		enterValueInTextField("userName",userName);
		enterValueInTextField("password",passWord);
		clickSignIn();
	}

	public boolean verifyTitle(String expectedTitle)
	{
		boolean flag = false;
		actualTitle =webDriver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)){
			flag= true;
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}
		return flag;
	}


	public void clickSpecificLink(String linkName)throws Exception{
		try {
			List<WebElement> links = webDriver.findElements(By.tagName("a"));
			@SuppressWarnings("unused")
			int linkcount = links.size(); 
			System.out.println(links.size()); 
			for (WebElement myElement : links)
			{
				String link = myElement.getText(); 
				System.out.println(link);
				if(link.equalsIgnoreCase(linkName))
				{
					myElement.click();
					break;
				}
			} 
		}catch (Exception e){
			System.out.println("error "+e);
		}
	}


	public void verifyText(String testName)throws Exception{
		try {
			List<WebElement> links = webDriver.findElements(By.tagName("font"));
			@SuppressWarnings("unused")
			int linkcount = links.size(); 
			System.out.println(links.size()); 
			for (WebElement myElement : links)
			{
				String link = myElement.getText(); 
				System.out.println(link);
				if(link.equalsIgnoreCase(testName))
				{
					System.out.println("Text is matched");  
					break;
				}
			} 
		}catch (Exception e){
			System.out.println("error "+e);
		}
	}


}
