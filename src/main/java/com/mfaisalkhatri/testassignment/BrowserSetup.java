package com.mfaisalkhatri.testassignment;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Faisal Khatri
 *
 */
public class BrowserSetup {
	
	protected WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(BrowserSetup.class.getName());

	/**
	 * This is a helper method to start browser 
	 * @param browserName
	 * @param website
	 */
	public void startBrowser(String browserName, String website) {

		try {
			if (browserName == null) {
				LOGGER.error("Browser Name can not be null!!");
			} else if (browserName.equalsIgnoreCase("CHROME")) {
				setupChromeDriver(website);

			} else {
				LOGGER.error("Please Specify Correct Browser - [CHROME]");
			}

		} catch (Exception e) {
			LOGGER.error("Error in BrowserSetup" + e.getMessage());
		}
	}

	/**
	 * This is a helper method to stop browser.
	 */
	public void stopBrowser() {
		try {
			if (driver != null) {
				LOGGER.info("Stopping Driver...");
				driver.quit();
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred while stopping browser" + e.getMessage());
		}
	}

	/**
	 * This helper methods is used for loading website.
	 * @param website
	 */
	public void loadWebsite(String website) {
		try {
			LOGGER.info("Loading Website...");
			driver.get(website);
		} catch (Exception e) {
			LOGGER.error("Error occurred while loading website." + e.getMessage());
		}
		
	}


	private void setupChromeDriver(String website) {
		try {
			final String exe = "chromedriver.exe";
			final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

			System.setProperty("webdriver.chrome.driver", path);

			LOGGER.info("Starting Chrome...");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			loadWebsite(website);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			LOGGER.info("Chrome Started...");
		} catch (Exception e) {
			LOGGER.error("Error in setting up Chrome Driver.." + e.getMessage());
		}
	}

}
