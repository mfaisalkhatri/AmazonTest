package com.mfaisalkhatri.testassignment.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.mfaisalkhatri.testassignment.BrowserSetup;
import com.mfaisalkhatri.testassignment.ConfigProperties;
import com.mfaisalkhatri.testassignment.pages.LoginPage;

/**
 * @author Faisal Khatri
 *
 */
public class Setup extends BrowserSetup {

	/**
	 * Setup Method to launch Browser and load Website as per setting in config file. 
	 * @throws Exception
	 */
	@BeforeTest
	public void siteup() throws Exception {
		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());
		LoginPage login = new LoginPage(driver);
		login.clickSignInLink();
	}

	/**
	 * Tear Down Method to quit Browser.
	 */
	@AfterTest
	public void tearDown() {
		stopBrowser();
	}
}
