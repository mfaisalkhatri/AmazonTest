package com.mfaisalkhatri.testassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This class contains helper methods for running tests.
 * @author Faisal Khatri
 *
 */
public class Utilities {

	private WebDriver driver;
	private WebElement element;

	/**
	 * @param driver
	 */
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param sleepValue
	 * @throws InterruptedException
	 */
	public static void sleep(int sleepValue) throws InterruptedException {

		Thread.sleep(sleepValue);
	}

	/**
	 * This Method helps to assert message texts. 
	 * @param locator
	 * @param message
	 */
	public void checkMessage(By locator, String message) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String msg = notif.getText();
		Assert.assertEquals(msg, message);

	}

	/**
	 * This method clicks, clears and than enters text in the element.
	 * @param element 
	 * @param text
	 */
	public void enterText(WebElement element, String text){
		element.click();
		element.clear();
		element.sendKeys(text);
	}

}