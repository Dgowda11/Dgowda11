package com.miniproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageBaseClass {
	public WebDriver driver;
	public Properties prop;

	// set system property
	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Darshan Gowda\\workspace\\MiniProject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Darshan Gowda\\workspace\\MiniProject\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		// driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		/********** Properties file *****/
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\resources\\ProjectProperties\\projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/***************** Open URl *********/
	public void openURL(String websiteURlkey) {

		try {
			driver.get(prop.getProperty(websiteURlkey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void propergender(String xpathkey) {
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();
	}

	public void entrpincode(String id, String data) {
		driver.findElement(By.id(prop.getProperty(id))).sendKeys(data);
	}

	public void enteremail(String id, String data) {
		driver.findElement(By.id(prop.getProperty(id))).sendKeys(data);
	}

	public void clickreset(String xpathkey) {
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();

	}

	/****************** Close Browser ***********************/
	public void tearDown() {
		driver.close();
	}

	/****************** Quit Browser ***********************/
	public void quitBrowser() {
		driver.quit();
	}

}
