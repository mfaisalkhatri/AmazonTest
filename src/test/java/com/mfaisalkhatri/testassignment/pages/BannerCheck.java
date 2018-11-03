package com.mfaisalkhatri.testassignment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 *
 */
public class BannerCheck {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public BannerCheck(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method fetches and verifies the list of banners on homepage.  
	 */
	public void checkBannersonHomePage() {

		List<WebElement> banner = driver.findElements(By.cssSelector("#anonCarousel1> ol > li"));
		int bannerSize = banner.size();
		System.out.println("Banners Checked Successfully, Total " + bannerSize + " displayed");
	}
}
