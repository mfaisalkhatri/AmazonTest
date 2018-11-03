package com.mfaisalkhatri.testassignment.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mfaisalkhatri.testassignment.pages.PasswordPage;
import com.mfaisalkhatri.testassignment.pages.UserNamePage;

/**
 * @author Faisal Khatri
 *
 */
public class AmazonTests extends Setup {

	/**
	 * This Tests Check and validates userNames.
	 * 
	 * @param userName
	 * @param scenario
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "usernames")
	public void userNameCheckTests(String userName, boolean scenario) throws IOException, InterruptedException {
		UserNamePage userNamePage = new UserNamePage(driver);
		userNamePage.checkUserName(userName, scenario);

	}

	/**
	 * This test checks and validates passwords, if correct password matches, system
	 * logs in and verifies the Welcome text and Changes the Pincode.
	 * 
	 * @param password
	 * @param scenario
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test(dataProvider = "passwords", dependsOnMethods = "userNameCheckTests")
	public void loginTests(String password, boolean scenario) throws InterruptedException, IOException {
		PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.checkPassword(password, scenario);
	}

	/**
	 * @return usernames
	 */
	@DataProvider
	public static Iterator<Object[]> usernames() {
		List<Object[]> data = new ArrayList<>();
		data.add(new Object[] { "user001", false });
		data.add(new Object[] { "", false });
		data.add(new Object[] { "mohammadfaisalkhatri@gmail.com", true });
		return data.iterator();
	}

	/**
	 * @return passwords
	 */

	@DataProvider
	public static Iterator<Object[]> passwords() {
		List<Object[]> data = new ArrayList<>();
		data.add(new Object[] { "user001", false });
		data.add(new Object[] { "", false });
		data.add(new Object[] { "Amazon@1", true });
		return data.iterator();
	}
}
