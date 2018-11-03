package com.mfaisalkhatri.testassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mfaisalkhatri.testassignment.Utilities;

/**
 * @author Faisal Khatri
 *
 */
public class UserNamePage {

	private WebDriver driver;
	private Utilities utilities;
	private Actions actions;
	private WebDriverWait wait;

	/**
	 * @param driver
	 */
	public UserNamePage(WebDriver driver) {
		this.driver = driver;
		this.utilities = new Utilities(driver);
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, 5);
	}

	/**
	 * @param userName
	 * @param scenario
	 * @throws InterruptedException
	 * 
	 */
	public void checkUserName(String userName, boolean scenario) throws InterruptedException {

		WebElement emailTxtBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		utilities.enterText(emailTxtBox, userName);

		String emailTextEntered = emailTxtBox.getAttribute("value");

		clickContinueBtn();

		if (!scenario) {
			if (emailTextEntered.isEmpty()) {
				blankUserNameAlertCheck();
			} else {
				invalidUserNameAlertCheck();
			}
		}
	}

	private void clickContinueBtn() {

		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		actions.click(continueBtn).build().perform();

	}

	private void blankUserNameAlertCheck() {

		String expectedAlertMessage = "Enter your email or mobile phone number";
		utilities.checkMessage(By.id("auth-email-missing-alert"), expectedAlertMessage);

	}

	private void invalidUserNameAlertCheck() {
		String expectedText = "There was a problem\nWe cannot find an account with that email address";
		utilities.checkMessage(By.cssSelector(".a-box-inner.a-alert-container"), expectedText);
	}

}
