package com.mfaisalkhatri.testassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Faisal Khatri
 *
 */
public class LoginPage {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * This method finds and clicks on "Sign in" link on the Home Page. 
	 */
	public void clickSignInLink() {
		Actions actions = new Actions(driver);
		WebElement signInLink = driver.findElement(By.id("nav-link-yourAccount"));
		actions.moveToElement(signInLink).build().perform();

		WebElement signInBtn = driver.findElement(By.linkText("Sign in"));
		actions.moveToElement(signInLink).click(signInBtn).build().perform();
	}

}
