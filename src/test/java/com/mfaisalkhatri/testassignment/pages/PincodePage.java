package com.mfaisalkhatri.testassignment.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mfaisalkhatri.testassignment.ConfigProperties;
import com.mfaisalkhatri.testassignment.Utilities;
/**
 * @author Faisal Khatri
 *
 */
public class PincodePage {

	private WebDriver driver;
	private Utilities utilities;

	/**
	 * @param driver
	 */
	public PincodePage(WebDriver driver) {
		this.driver = driver;
		this.utilities = new Utilities(driver);
	}

	/**
	 * @param pincode
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void changePincode(String pincode) throws IOException, InterruptedException {

		clickOnPincodeLink();
		clickOnChangeBtn();

		WebElement pincodeChangeWindow = driver.findElement(By.cssSelector(".a-popover-wrapper"));
		WebElement pincodeText = pincodeChangeWindow.findElement(By.id("GLUXZipUpdateInput"));
		utilities.enterText(pincodeText, pincode);

		clickAppyButton();
		clickDoneBtn();
		verifyPincodeValue();
	}

	private void clickOnPincodeLink() {
		WebElement pincodeLink = driver.findElement(By.cssSelector(".nav-a.nav-a-2.a-popover-trigger.a-declarative"));
		pincodeLink.click();
	}

	private void clickOnChangeBtn() {
		WebElement parentchangeLink = driver.findElement(By.cssSelector("#GLUXZipConfirmationSection"));
		WebElement changeBtn = parentchangeLink.findElement(By.cssSelector("#GLUXChangePostalCodeLink"));
		changeBtn.click();
	}

	private void clickAppyButton() {
		WebElement applyBtn = driver.findElement(By.cssSelector(".a-column.a-span4.a-span-last"));
		applyBtn.click();
	
	}

	private void clickDoneBtn() {
		WebElement footer = driver.findElement(By.cssSelector(".a-popover-footer"));
		WebElement doneBtn = footer.findElement(By.cssSelector(".a-button-primary"));
		doneBtn.click();
	}

	private void verifyPincodeValue() throws IOException {
		driver.navigate().refresh();
		WebElement pincodeLink = driver.findElement(By.cssSelector(
				".nav-a.nav-a-2.a-popover-trigger.a-declarative > div#glow-ingress-block > span#glow-ingress-line2"));
		String pincodeText = pincodeLink.getText();
		ConfigProperties config = new ConfigProperties();
		String expectedPincode = config.getPincode();
		Assert.assertTrue(pincodeText.contains(expectedPincode));
		
		System.out.println("Pincode "+expectedPincode + " Set Successfully.");
	}
}
