package com.mfaisalkhatri.testassignment.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mfaisalkhatri.testassignment.ConfigProperties;
import com.mfaisalkhatri.testassignment.Utilities;

/**
 * @author Faisal Khatri
 *
 */
public class PasswordPage {

	private WebDriver driver;
	private Utilities utilities;
	private WebDriverWait wait;

	/**
	 * @param driver
	 */
	public PasswordPage(WebDriver driver) {
		this.driver = driver;
		this.utilities = new Utilities(driver);
		this.wait = new WebDriverWait(driver, 5);
	}

	/**
	 * This method validates the password and if success, than logs in website,
	 * Check Welcome text and Changes Pincode.
	 * 
	 * @param password
	 * @param scenario
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void checkPassword(String password, boolean scenario) throws InterruptedException, IOException {

		WebElement passwordTxtBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		utilities.enterText(passwordTxtBox, password);

		String passwordText = passwordTxtBox.getAttribute("value");
		clickLoginBtn();

		if (!scenario) {
			if (passwordText.isEmpty()) {
				blankPasswordAlertCheck();
			} else
				passwordValidationAlertCheck();
		} else {
			validateLogin();
			bannerCheck();
			pincodeChange();
		}

	}

	private void clickLoginBtn() {
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit")));
		loginBtn.click();
	}

	/**
	 * This method checks blank Password alert.
	 */
	private void blankPasswordAlertCheck() {

		String expectedAlertMessage = "Enter your password";
		utilities.checkMessage(By.id("auth-password-missing-alert"), expectedAlertMessage);

	}

	/**
	 * This method verifies the incorrect password text.
	 */
	private void passwordValidationAlertCheck() {
		String expectedText = "Your password is incorrect";
		utilities.checkMessage(By.cssSelector(".a-box-inner.a-alert-container > .a-alert-content"), expectedText);
	}

	/**
	 * This method checks for the welcome text after successful login
	 */
	private void validateLogin() {
		WebElement welcomeTextLink = driver.findElement(By.cssSelector("#nav-link-yourAccount > span.nav-line-1"));

		String actWelcomeText = welcomeTextLink.getText();
		String expText = "Hello, Faisal";
		Assert.assertEquals(actWelcomeText, expText);

	}

	private void bannerCheck() {
		BannerCheck banner = new BannerCheck(driver);
		banner.checkBannersonHomePage();
	}

	private void pincodeChange() throws IOException, InterruptedException {
		PincodePage pincodechange = new PincodePage(driver);
		ConfigProperties config = new ConfigProperties();
		pincodechange.changePincode(config.getPincode());

	}
}
