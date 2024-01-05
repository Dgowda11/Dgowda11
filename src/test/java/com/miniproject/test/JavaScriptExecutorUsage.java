package com.miniproject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.miniproject.PageBaseClass;

public class JavaScriptExecutorUsage extends PageBaseClass {

	@Test
	public void test() {

		invokeBrowser("chrome");
		// Open URl
		openURL("websiteURL");

		/********** JavaScript Executor Usage ***********/
		JavascriptExecutor jss = (JavascriptExecutor) driver;

		// Handle Alert
		jss.executeScript("alert('hello world');");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Close the alert
		driver.switchTo().alert().dismiss();

		// Navigate to different webpage
		jss.executeScript("window.location = 'https://stqatools.com/demo/'");

		// Switching driver position
		driver.get("https://stqatools.com/demo/");
		// Creating the JavascriptExecutor interface object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Enter Valves in the text Box
		js.executeScript("document.getElementById('studentname').value='Amol'");
		js.executeScript("document.getElementById('fathername').value='Raj'");
		js.executeScript("document.getElementById('paddress').value='Mumbai'");
		js.executeScript("document.getElementById('personaladdress').value='Mumbai'");

		// Select proper Gender
		propergender("gender_male");

		// To select the city from the drop down menu
		Select city = new Select(driver.findElement(By.name("City")));
		city.selectByVisibleText("PATNA");

		// To select the course from the drop down menu
		Select course = new Select(driver.findElement(By.name("Course")));
		course.selectByVisibleText("B.TECH");

		// To select the district from the drop down menu
		Select dst = new Select(driver.findElement(By.name("District")));
		dst.selectByVisibleText("NALANDA");

		// To select the state from the drop down menu
		Select st = new Select(driver.findElement(By.name("State")));
		st.selectByVisibleText("BIHAR");

		// To enter the pin code in the text box
		entrpincode("pincode_id", "411009");

		// To enter the email id in the text box
		enteremail("email_id", "abc@gmail.com");

		// Click on reset form
		clickreset("reset_btn");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String check = (String) js
				.executeScript("return document.getElementById('studentname').value");
		if (check != "") {
			System.out.println("Reset Successfully");
			driver.close();
		} else
			System.out.println(" Not Submited");

		quitBrowser();
	}

}
